package DynamicProgramming.KnapsackProblem;

import java.util.Arrays;

public class Problem0377 {
    public int combinationSum4(int[] nums,int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int currentSum = 1; currentSum <= target; ++currentSum) {
            for (int num : nums) {
                if (currentSum >= num) {
                    dp[currentSum] += dp[currentSum - num];
                }
            }
        }
        return dp[target];
    }
}
