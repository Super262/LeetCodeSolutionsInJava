package Solutions;

public class Problem0072 {
    public int minDistance(String word1,String word2) {
        final int wLen1 = word1 == null ? 0 : word1.length();
        final int wLen2 = word2 == null ? 0 : word2.length();
        if (wLen1 == 0) {
            return wLen2;
        }
        if (wLen2 == 0) {
            return wLen1;
        }
        int[][] dp = new int[2][wLen2 + 1];
        for (int l2 = 1; l2 <= wLen2; ++l2) {
            dp[0][l2] = l2;
        }
        for (int l1 = 1; l1 <= wLen1; ++l1) {
            int newL1 = l1 % 2;
            int oldL1 = (l1 - 1) % 2;
            dp[newL1][0] = l1;
            for (int l2 = 1; l2 <= wLen2; ++l2) {
                if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
                    dp[newL1][l2] = Math.min(dp[oldL1][l2 - 1],Math.min(dp[oldL1][l2] + 1,dp[newL1][l2 - 1] + 1));
                } else {
                    dp[newL1][l2] = Math.min(dp[oldL1][l2 - 1] + 1,Math.min(dp[oldL1][l2] + 1,dp[newL1][l2 - 1] + 1));
                }
            }
        }
        return dp[wLen1 % 2][wLen2];
    }
}
