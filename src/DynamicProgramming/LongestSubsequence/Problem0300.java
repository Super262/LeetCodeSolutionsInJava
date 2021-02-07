package DynamicProgramming.LongestSubsequence;

public class Problem0300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int preMax;
        int result = 1;
        for (int i = 1; i < nums.length; ++i) {
            preMax = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    preMax = Math.max(preMax,dp[j]);
                }
            }
            dp[i] = preMax + 1;
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
