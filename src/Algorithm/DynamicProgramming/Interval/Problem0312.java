package Algorithm.DynamicProgramming.Interval;

public class Problem0312 {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] values = new int[nums.length + 2];
        int[][] dp = new int[values.length][values.length];
        System.arraycopy(nums,0,values,1,values.length - 1 - 1);
        values[0] = 1;
        values[values.length - 1] = 1;
        for (int i = 0; i < values.length - 1; ++i) {
            dp[i][i + 1] = 0;
        }
        for (int len = 3; len <= values.length; ++len) {
            for (int i = 0; i < values.length - len + 1; ++i) {
                int j = i + len - 1;
                dp[i][j] = 0;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][values.length - 1];
    }
}
