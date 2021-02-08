package DynamicProgramming.EditString;

public class Problem0650 {
    public int minSteps(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        int[] factors;
        for (int l = 2; l <= n; ++l) {
            factors = getMaxFactor(l);
            if (factors[0] == 1) {
                dp[l] = l;
            } else {
                dp[l] = dp[factors[1]] + factors[0];
            }
        }
        return dp[n];
    }

    private int[] getMaxFactor(int a) {
        // a >= 0
        if (a < 2) {
            return new int[]{a,a};
        } else {
            int[] result = new int[]{1,a};
            for (int f2 = a - 1; f2 > 1; --f2) {
                if (a % f2 == 0) {
                    result[1] = f2;
                    result[0] = a / f2;
                    break;
                }
            }
            return result;
        }
    }
}
