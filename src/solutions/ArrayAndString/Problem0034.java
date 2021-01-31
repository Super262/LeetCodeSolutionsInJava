package solutions.ArrayAndString;

public class Problem0034 {
    private int[] searchForRange(int[] nums,int start,int end,int target) {
        if (start >= end) {
            return new int[]{-1, -1};
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            int[] result = new int[]{mid, mid};
            for (int i = mid + 1; i < end; ++i) {
                result[1] = nums[i] == target ? i : result[1];
            }
            for (int i = mid - 1; i >= start; --i) {
                result[0] = nums[i] == target ? i : result[0];
            }
            return result;
        } else if (nums[mid] > target) {
            return searchForRange(nums,start,mid,target);
        } else {
            return searchForRange(nums,mid + 1,end,target);
        }
    }

    public int[] searchRange(int[] nums,int target) {
        return searchForRange(nums, 0, nums.length, target);
    }
}