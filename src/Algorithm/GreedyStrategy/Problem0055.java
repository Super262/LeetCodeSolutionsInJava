package Algorithm.GreedyStrategy;

public class Problem0055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int current_bound;
        int next_start;
        while (start < nums.length) {
            current_bound = start + nums[start];

            // 不能改变下面的两个if语句块的顺序，应对特殊情况：nums = [1]
            if (current_bound >= nums.length - 1) {
                return true;
            }
            if (current_bound <= start) {
                return false;
            }

            next_start = start + 1;
            for (int candidate = start + 2; candidate <= current_bound; ++candidate) {
                if (candidate + nums[candidate] >= next_start + nums[next_start]) {
                    next_start = candidate;
                }
            }
            start = next_start;
        }
        return false;
    }
}
