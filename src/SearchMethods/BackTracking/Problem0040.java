package SearchMethods.BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0040 {
    public List<List<Integer>> combinationSum2(int[] candidates,int target) {
        Arrays.sort(candidates);
        return getCombinationsWithNoRepeat(candidates,0,target);
    }

    private List<List<Integer>> getCombinationsWithNoRepeat(int[] candidates,final int start,final int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (start < candidates.length && target >= candidates[start]) {
            int nextStart = start + 1;
            while (nextStart < candidates.length && candidates[nextStart] == candidates[start]) {
                ++nextStart;
            }
            result.addAll(getCombinationsWithNoRepeat(candidates,nextStart,target));
            if (candidates[start] == target) {
                List<Integer> temp = new LinkedList<>();
                temp.add(candidates[start]);
                result.add(temp);
            } else {
                for (List<Integer> l : getCombinationsWithNoRepeat(candidates,start + 1,target - candidates[start])) {
                    l.add(0,candidates[start]);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
