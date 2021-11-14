package Solutions;

public class Problem0300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentLen = 1;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int tempIndex;
        for (int i = 1; i < nums.length; ++i) {
            tempIndex = findPreMax(tails,currentLen,nums[i]);
            tails[tempIndex] = nums[i];
            if (tempIndex == currentLen) {
                ++currentLen;
            }
        }
        return currentLen;
    }

    private int findPreMax(int[] nums,final int end,final int key) {
        int low = 0;
        int high = end;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
