package Algorithm.GreedyStrategy;

public class Problem0045 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int start = 0;
        int nextStart;
        int currentBound;
        while (start < nums.length - 1) {
            ++result;
            nextStart = start;
            currentBound = start + nums[start];
            if (currentBound >= nums.length - 1) {
                return result;
            }
            for (int i = start + 1; i <= currentBound; ++i) {
                if (i + nums[i] >= nextStart + nums[nextStart]) {
                    nextStart = i;
                }
            }
            start = nextStart;
        }
        return result;
    }
}
