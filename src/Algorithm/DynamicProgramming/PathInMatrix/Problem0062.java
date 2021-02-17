package Algorithm.DynamicProgramming.PathInMatrix;

public class Problem0062 {
    public int uniquePaths(final int m,final int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int y = 1; y < m; ++y) {
            dp[y][0] = dp[y - 1][0];
        }
        for (int x = 1; x < n; ++x) {
            dp[0][x] = dp[0][x - 1];
        }
        for (int y = 1; y < m; ++y) {
            for (int x = 1; x < n; ++x) {
                dp[y][x] = dp[y - 1][x] + dp[y][x - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
