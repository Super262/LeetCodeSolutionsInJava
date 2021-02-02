package Sequencing;

public class Problem0215 {
    private int partition(int[] nums,int start,int end) {
        if (start == end) {
            return start;
        }
        int j = end;
        int i = start;
        int pivot = nums[start];
        while (i < j) {
            while (j > i && nums[j] <= pivot) {
                --j;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] > pivot) {
                ++i;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        return i;
    }

    public int findKthLargest(int[] nums,int k) {
        k = k - 1;
        int low = 0;
        int high = nums.length - 1;
        while (high > low) {
            int p = partition(nums,low,high);
            if (p == k) {
                return nums[p];
            } else if (p > k) {
                high = p;
            } else {
                low = p;
            }
        }
        return nums[low];
    }
}
