package Algorithm.GreedyStrategy;

public class Problem0055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int currentBound;
        int nextStart;
        while (start < nums.length) {
            currentBound = start + nums[start];

            // 不能改变下面的两个if语句块的顺序，应对特殊情况：nums = [1]
            if (currentBound >= nums.length - 1) {
                return true;
            }
            if (currentBound <= start) {
                return false;
            }

            nextStart = start + 1;
            for (int candidate = start + 2; candidate <= currentBound; ++candidate) {
                if (candidate + nums[candidate] >= nextStart + nums[nextStart]) {
                    nextStart = candidate;
                }
            }
            start = nextStart;
        }
        return false;
    }
}
