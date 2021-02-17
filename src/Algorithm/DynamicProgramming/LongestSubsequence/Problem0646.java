package Algorithm.DynamicProgramming.LongestSubsequence;

import java.util.Arrays;

public class Problem0646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs,(a,b) -> a[0] < b[0] ? -1 : 0);
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int preMax;
        int result = 1;
        for (int i = 1; i < pairs.length; ++i) {
            preMax = 0;
            for (int j = 0; j < i; ++j) {
                if (pairs[j][1] < pairs[i][0]) {
                    preMax = Math.max(preMax,dp[j]);
                }
            }
            dp[i] = preMax + 1;
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
