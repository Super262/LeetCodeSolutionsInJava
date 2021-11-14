package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0039 {
    public List<List<Integer>> combinationSum(int[] candidates,int target) {
        int[] candidatesUnique = new int[candidates.length];
        System.arraycopy(candidates,0,candidatesUnique,0,candidates.length);
        Arrays.sort(candidatesUnique);
        List<List<Integer>> results = new LinkedList<>();
        dfs(candidatesUnique,0,target,new ArrayList<>(),results);
        return results;
    }

    private void dfs(int[] candidates,int startIndex,final int target,ArrayList<Integer> combination,List<List<Integer>> results) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < candidates.length; ++i) {
            if (candidates[i] > target) {
                return;
            }
            combination.add(candidates[i]);
            dfs(candidates,i,target - candidates[i],combination,results);
            combination.remove(combination.size() - 1);
        }
    }
}
