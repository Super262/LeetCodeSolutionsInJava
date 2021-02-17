package Algorithm.DynamicProgramming.Partition;

public class Problem0091 {
    public int numDecodings(String s) {
        if (s == null) {
            return 1;
        }
        int sLen = s.length();
        if (sLen == 0) {
            return 1;
        }
        int[] dp = new int[sLen + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int l = 2; l <= sLen; ++l) {
            if (s.charAt(l - 1) != '0') {
                dp[l] += dp[l - 1];
            }
            if (s.charAt(l - 2) != '0') {
                if ((s.charAt(l - 2) - '0') * 10 + (s.charAt(l - 1) - '0') < 27) {
                    dp[l] += dp[l - 2];
                }
            }
        }
        return dp[sLen];
    }
}
