package DynamicProgramming.PathInMatrix;

public class Problem0064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int height = grid.length;
        final int width = grid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for (int y = 1; y < height; ++y) {
            dp[y][0] = dp[y - 1][0] + grid[y][0];
        }
        for (int x = 1; x < width; ++x) {
            dp[0][x] = dp[0][x - 1] + grid[0][x];
        }
        for (int y = 1; y < height; ++y) {
            for (int x = 1; x < width; ++x) {
                dp[y][x] = Math.min(dp[y - 1][x] + grid[y][x],dp[y][x - 1] + grid[y][x]);
            }
        }
        return dp[height - 1][width - 1];
    }
}
