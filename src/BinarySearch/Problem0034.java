package BinarySearch;

public class Problem0034 {
    public int[] searchRange(int[] nums,int target) {
        int[] result = new int[]{-1,-1};
        int start = 0;
        int end = nums.length;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                for (int i = mid; i < end; ++i) {
                    result[1] = nums[i] == target ? i : result[1];
                }
                for (int i = mid; i >= start; --i) {
                    result[0] = nums[i] == target ? i : result[0];
                }
                return result;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}