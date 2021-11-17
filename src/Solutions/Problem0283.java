package Solutions;

public class Problem0283 {
    public void moveZeroes(int[] nums) {
        // Minimize the total number of operations!
        if (nums == null) {
            return;
        }
        int k = 0;
        for (int x : nums) {
            if (x == 0) {
                continue;
            }
            nums[k++] = x;
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
