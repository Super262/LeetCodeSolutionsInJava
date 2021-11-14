package Solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        int[] numsCopied = new int[nums.length];
        System.arraycopy(nums,0,numsCopied,0,nums.length);
        Arrays.sort(numsCopied);
        helper(numsCopied,0,new LinkedList<>(),results);
        return results;
    }

    private void helper(int[] nums,int startIndex,LinkedList<Integer> subset,List<List<Integer>> results) {
        results.add(new LinkedList<>(subset));
        for (int i = startIndex; i < nums.length; ++i) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.addLast(nums[i]);
            helper(nums,i + 1,subset,results);
            subset.removeLast();
        }
    }
}
