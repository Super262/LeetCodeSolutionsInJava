package Algorithm.BinarySearch;

public class Problem0034 {
    private int findFirst(int[] nums,int target) {
        int low = 0;
        int high = nums.length;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int[] searchRange(int[] nums,int target) {
        int[] result = new int[]{-1,-1};
        int firstIndex = findFirst(nums,target);
        if (firstIndex < nums.length && nums[firstIndex] == target) {
            result[0] = firstIndex;
            result[1] = firstIndex;
        }
        if (result[0] != -1) {
            // 巧妙之处：选择(target+1)作为下一个查找目标
            result[1] = findFirst(nums,target + 1) - 1;
        }
        return result;
    }
}