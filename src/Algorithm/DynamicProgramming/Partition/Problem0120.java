package Algorithm.DynamicProgramming.Partition;

import java.util.List;

public class Problem0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int N = triangle.size();
        int[][] dp = new int[N][];
        for (int i = 0; i < N; ++i) {
            dp[i] = new int[i + 1];
        }
        for (int i = 0; i < N; ++i) {
            dp[N - 1][i] = triangle.get(N - 1).get(i);
        }
        for (int i = N - 2; i >= 0; --i) {
            for (int j = 0; j < dp[i].length; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
