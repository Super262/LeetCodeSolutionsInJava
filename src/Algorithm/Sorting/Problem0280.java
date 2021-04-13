package Algorithm.Sorting;

public class Problem0280 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1])) {
                swap(nums,i - 1,i);
            }
        }
    }

    private void swap(int[] nums,int a,int b) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
