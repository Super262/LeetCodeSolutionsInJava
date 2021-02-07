package DynamicProgramming.KnapsackProblem;

public class Problem0416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum,num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int targetSum = sum / 2;
        if (maxNum > targetSum) {
            return false;
        }
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = targetSum; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[targetSum];
    }
}
