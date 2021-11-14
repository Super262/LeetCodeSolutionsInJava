package Solutions;

public class Problem0283 {
    public void moveZeroes(int[] nums) {
        // Minimize the total number of operations!
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                ++left;
            }
            ++right;
        }
        while (left < nums.length) {
            nums[left] = 0;
            ++left;
        }
    }
}
