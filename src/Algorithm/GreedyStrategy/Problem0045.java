package Algorithm.GreedyStrategy;

public class Problem0045 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int start = 0;
        int current_bound;
        int next_start;
        while (start < nums.length) {
            if (start >= nums.length - 1) {
                return result;
            }
            if (nums[start] <= 0) {
                return nums.length;
            }
            ++result;
            current_bound = start + nums[start];
            if (current_bound >= nums.length - 1) {
                return result;
            }
            next_start = start + 1;
            for (int candidate = start + 2; candidate <= current_bound; ++candidate) {
                if (candidate + nums[candidate] >= next_start + nums[next_start]) {
                    next_start = candidate;
                }
            }
            start = next_start;
        }
        return nums.length;
    }
}
