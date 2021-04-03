package Algorithm.SearchMethods.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0078 {
    public List<List<Integer>> subsets(int[] nums) {
        int[] numsCopied = new int[nums.length];
        System.arraycopy(nums,0,numsCopied,0,nums.length);
        Arrays.sort(numsCopied);
        List<List<Integer>> results = new LinkedList<>();
        helper(numsCopied,0,new ArrayList<>(numsCopied.length),results);
        return results;
    }

    private void helper(int[] nums,int index,List<Integer> subset,List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; ++i) {
            subset.add(nums[i]);
            helper(nums,i + 1,subset,results);
            subset.remove(subset.size() - 1);
        }
    }
}
