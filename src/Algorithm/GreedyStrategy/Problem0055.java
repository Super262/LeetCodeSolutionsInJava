package Algorithm.GreedyStrategy;

public class Problem0055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int globalBound = 0;
        int currentBound;
        for (int i = 0; i < nums.length; ++i) {
            if (i > globalBound) {
                continue;
            }
            currentBound = i + nums[i];
            if (currentBound > globalBound) {
                globalBound = currentBound;
            }
            if (globalBound >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
