package Solutions;

public class Problem0303 {
    private static class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            if (nums != null && nums.length != 0) {
                preSum = new int[nums.length + 1];
                preSum[0] = nums[0];
                for (int i = 0; i < nums.length; i++) {
                    preSum[i + 1] = preSum[i] + nums[i];
                }
            }
        }

        public int sumRange(int i,int j) {
            if (preSum != null && preSum.length != 0) {
                return preSum[j + 1] - preSum[i - 1];
            } else {
                return 0;
            }

        }
    }
}
