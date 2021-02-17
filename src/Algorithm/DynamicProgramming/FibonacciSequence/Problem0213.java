package Algorithm.DynamicProgramming.FibonacciSequence;

public class Problem0213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        return Math.max(robPart(nums,0,nums.length - 1,dp),robPart(nums,1,nums.length - 1,dp));
    }

    private int robPart(int[] nums,int start,int partLen,int[] dp) {
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i <= partLen; ++i) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[start + i - 1]);
        }
        return dp[partLen];
    }
}
