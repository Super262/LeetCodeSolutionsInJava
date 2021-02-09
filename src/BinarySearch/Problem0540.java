package BinarySearch;

public class Problem0540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mid % 2 == 0) {
                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }
}
