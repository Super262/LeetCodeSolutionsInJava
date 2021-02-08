package Sorting;

public class Problem0075 {
    public void sortColors(int[] nums) {
        int zeroP = -1;
        int oneP = 0;
        int twoP = nums.length;
        while (oneP < twoP) {
            if (nums[oneP] == 1) {
                ++oneP;
            } else if (nums[oneP] == 2) {
                swap(nums,oneP,--twoP);
            } else {
                swap(nums,oneP++,++zeroP);
            }
        }
    }

    private void swap(int[] nums,int a,int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
