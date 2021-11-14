package Solutions;

public class Problem0494 {
    public int findTargetSumWays(int[] nums,int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || S < -sum) {
            return 0;
        }
        int targetSum = (sum + S);
        if (targetSum % 2 != 0) {
            return 0;
        }
        targetSum /= 2;
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;
        int currentNum;
        for (int currentLen = 1; currentLen <= nums.length; ++currentLen) {
            currentNum = nums[currentLen - 1];
            for (int currentSum = targetSum; currentSum >= currentNum; --currentSum) {
                dp[currentSum] = dp[currentSum] + dp[currentSum - currentNum];
            }
        }
        return dp[targetSum];
    }
}
