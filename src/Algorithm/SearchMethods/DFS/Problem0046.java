package Algorithm.SearchMethods.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,new ArrayList<>(nums.length),results);
        return results;
    }

    private void dfs(int[] nums,boolean[] visited,ArrayList<Integer> permutation,List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(nums,visited,permutation,results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
