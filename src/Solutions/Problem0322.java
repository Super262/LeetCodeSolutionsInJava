package Solutions;

import java.util.Arrays;

public class Problem0322 {
    public int coinChange(int[] coins,int amount) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int change = 1; change <= amount; ++change) {
            for (int coin : coins) {
                if (change >= coin) {
                    dp[change] = Math.min(dp[change],dp[change - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
