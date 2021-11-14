package Solutions;

public class Problem0097 {
    public boolean isInterleave(String s1,String s2,String s3) {
        final int sLen1 = s1 == null ? 0 : s1.length();
        final int sLen2 = s2 == null ? 0 : s2.length();
        final int sLen3 = s3 == null ? 0 : s3.length();
        if (sLen1 + sLen2 != sLen3) {
            return false;
        }
        boolean[][] dp = new boolean[2][sLen2 + 1];
        dp[0][0] = true;
        for (int l = 1; l <= sLen2; ++l) {
            if (s3.charAt(l - 1) != s2.charAt(l - 1)) {
                break;
            }
            dp[0][l] = dp[0][l - 1];
        }
        for (int l1 = 1; l1 <= sLen1; ++l1) {
            int newL1 = l1 % 2;
            int oldL1 = (l1 - 1) % 2;
            dp[newL1][0] = dp[oldL1][0] && s3.charAt(l1 - 1) == s1.charAt(l1 - 1);
            for (int l2 = 1; l2 <= sLen2; ++l2) {
                dp[newL1][l2] = (s3.charAt(l1 + l2 - 1) == s1.charAt(l1 - 1) && dp[oldL1][l2]) || (s3.charAt(l1 + l2 - 1) == s2.charAt(l2 - 1) && dp[newL1][l2 - 1]);
            }
        }
        return dp[sLen1 % 2][sLen2];
    }
}
