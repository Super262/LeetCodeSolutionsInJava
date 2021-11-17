package Solutions;

import java.util.Arrays;

public class Problem0300 {
    public int lengthOfLIS(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int n = nums.length;
        int[] lisTail = new int[n + 1];
        int result = 0;
        Arrays.fill(lisTail,Integer.MAX_VALUE);
        for (int t : nums) {
            int l = 0;
            int r = result;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (lisTail[mid] >= t) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            lisTail[l + 1] = Math.min(lisTail[l + 1],t);
            result = Math.max(result,l + 1);
        }
        return result;
    }
}
