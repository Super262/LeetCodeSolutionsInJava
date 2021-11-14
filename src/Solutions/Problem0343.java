package Solutions;

public class Problem0343 {
    public int integerBreak(int n) {
        if (n < 3) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;  // "n = 1" would not occur.
        dp[2] = 1;

        int temp1;
        int temp2;
        for (int digit = 3; digit <= n; ++digit) {
            for (int prePart = 1; prePart < digit; ++prePart) {
                temp1 = prePart * (digit - prePart);
                temp2 = dp[prePart] * (digit - prePart);
                dp[digit] = Math.max(dp[digit],Math.max(temp1,temp2));
            }
        }
        return dp[n];
    }
}
