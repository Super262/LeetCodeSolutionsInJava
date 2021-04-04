package Algorithm.SearchMethods.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] numsCopied = new int[nums.length];
        System.arraycopy(nums,0,numsCopied,0,nums.length);
        Arrays.sort(numsCopied);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> results = new LinkedList<>();
        dfs(numsCopied,visited,new ArrayList<>(nums.length),results);
        return results;
    }

    private void dfs(int[] nums,boolean[] visited,ArrayList<Integer> permutation,List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
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
