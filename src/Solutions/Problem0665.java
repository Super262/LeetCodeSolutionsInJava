package Solutions;

public class Problem0665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                if (nonDecreasing(nums)) {
                    return true;
                } else {
                    nums[i] = temp;
                    nums[i + 1] = nums[i];
                    return nonDecreasing(nums);
                }
            }
        }
        return true;
    }

    private boolean nonDecreasing(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
