package Algorithm.DynamicProgramming.LongestSubsequence;

public class Problem1143 {
    public int longestCommonSubsequence(String text1,String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int sLen1 = text1.length();
        int sLen2 = text2.length();
        int[][] dp = new int[2][sLen2 + 1];
        for (int l1 = 1; l1 <= sLen1; ++l1) {
            int newL1 = l1 % 2;
            int oldL1 = (l1 - 1) % 2;
            for (int l2 = 1; l2 <= sLen2; ++l2) {
                if (text1.charAt(l1 - 1) == text2.charAt(l2 - 1)) {
                    dp[newL1][l2] = dp[oldL1][l2 - 1] + 1;
                } else {
                    dp[newL1][l2] = Math.max(dp[oldL1][l2],dp[newL1][l2 - 1]);
                }
            }
        }
        return dp[sLen1 % 2][sLen2];
    }
}
