package Solutions;

public class Problem0474 {
    public int findMaxForm(String[] strs,int m,int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        int tempLen;
        int currentZeros;
        int currentOnes;
        for (String s : strs) {
            currentOnes = 0;
            currentZeros = 0;
            tempLen = s.length();
            for (int j = 0; j < tempLen; ++j) {
                if (s.charAt(j) == '0') {
                    ++currentZeros;
                } else {
                    ++currentOnes;
                }
            }
            for (int zerosCount = m; zerosCount >= 0; --zerosCount) {
                for (int onesCount = n; onesCount >= 0; --onesCount) {
                    if (zerosCount >= currentZeros && onesCount >= currentOnes) {
                        dp[zerosCount][onesCount] = Math.max(dp[zerosCount][onesCount],dp[zerosCount - currentZeros][onesCount - currentOnes] + 1);
                    } else {
                        dp[zerosCount][onesCount] = dp[zerosCount][onesCount];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
