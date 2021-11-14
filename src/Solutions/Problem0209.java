package Solutions;

public class Problem0209 {
    public int minSubArrayLen(int target,int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < nums.length) {
            currentSum += nums[right];
            while (left <= right && currentSum >= target) {
                if (minLen <= 0 || right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                currentSum -= nums[left];
                ++left;
            }
            ++right;
        }
        return minLen;
    }
}
