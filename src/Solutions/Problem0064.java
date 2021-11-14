package Solutions;

public class Problem0064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int height = grid.length;
        final int width = grid[0].length;
        int[][] dp = new int[2][width];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < height; ++i) {
            int newI = i % 2;
            int oldI = (i - 1) % 2;
            for (int j = 0; j < width; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i != 0 && j != 0) {
                    dp[newI][j] = Math.min(dp[newI][j - 1],dp[oldI][j]) + grid[i][j];
                } else if (i != 0) {
                    dp[newI][j] = dp[oldI][j] + grid[i][j];
                } else {
                    dp[newI][j] = dp[newI][j - 1] + grid[i][j];
                }
            }
        }
        return dp[(height - 1) % 2][width - 1];
    }
}
