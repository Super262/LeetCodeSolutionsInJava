package Algorithm.SearchMethods.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0039 {
    public List<List<Integer>> combinationSum(int[] candidates,int target) {
        Arrays.sort(candidates);
        return getCombinations(candidates,0,target);
    }

    private List<List<Integer>> getCombinations(int[] candidates,final int start,final int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (start < candidates.length && target >= candidates[start]) {
            final int maxCount = target / candidates[start];
            // count = 0
            result.addAll(getCombinations(candidates,start + 1,target));

            // count > 0
            int prevSum;
            for (int count = 1; count <= maxCount; ++count) {
                prevSum = count * candidates[start];
                if (prevSum < target) {
                    List<List<Integer>> postPart = getCombinations(candidates,start + 1,target - prevSum);
                    if (!postPart.isEmpty()) {
                        List<Integer> prefix = new LinkedList<>();
                        for (int k = 0; k < count; ++k) {
                            prefix.add(0,candidates[start]);
                        }
                        for (List<Integer> postfix : postPart) {
                            postfix.addAll(0,prefix);
                            result.add(postfix);
                        }
                    }
                } else {
                    List<Integer> temp = new LinkedList<>();
                    for (int k = 0; k < count; ++k) {
                        temp.add(candidates[start]);
                    }
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
