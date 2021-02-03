package BinarySearch;

public class Problem0540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        int mid, midL, midR;
        while (low <= high) {
            mid = low + (high - low) / 2;
            midL = mid - 1 >= 0 ? nums[mid - 1] : nums[0] - 1;
            midR = mid + 1 < nums.length ? nums[mid + 1] : nums[nums.length - 1] + 1;
            if (nums[mid] != midL && nums[mid] != midR) {
                return nums[mid];
            } else {
                if (nums[mid] == midL) {
                    if ((mid - low + 1) % 2 == 0) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                } else if (nums[mid] == midR) {
                    if ((high - mid + 1) % 2 == 0) {
                        high = mid - 1;
                    } else {
                        low = mid;
                    }
                }
            }
        }
        return nums[0];
    }
}
