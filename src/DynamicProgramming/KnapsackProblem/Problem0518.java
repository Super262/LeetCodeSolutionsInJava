package DynamicProgramming.KnapsackProblem;

public class Problem0518 {
    public int change(int amount,int[] coins) {
        if (coins == null) {
            return 0;
        }
        if (amount == 0) {
            // This is very important!
            return 1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int cur = coin; cur <= amount; ++cur) {
                dp[cur] += dp[cur - coin];
            }
        }
        return dp[amount];
    }
}
