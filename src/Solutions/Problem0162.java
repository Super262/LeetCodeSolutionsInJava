package Solutions;

public class Problem0162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (getValue(nums,mid - 1) > getValue(nums,mid)) {
                right = mid;
            } else if (getValue(nums,mid + 1) > getValue(nums,mid)) {
                left = mid;
            } else {
                return mid;
            }
        }
        if (nums[left] > nums[right]) {
            return left;
        } else {
            return right;
        }
    }

    private int getValue(int[] nums,int index) {
        if (index < 0 || index > nums.length) {
            return Integer.MIN_VALUE;
        }
        return nums[index];
    }
}
