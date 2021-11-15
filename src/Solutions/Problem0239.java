package Solutions;

class Problem0239 {
    public int[] maxSlidingWindow(final int[] nums,final int k) {
        int[] q = new int[nums.length + 1];
        int hh = 0, tt = -1;
        int[] result = new int[nums.length - (k - 1)];
        int resTop = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (hh <= tt && q[tt] - q[hh] + 1 == k) {
                ++hh;
            }
            while (hh <= tt && nums[q[tt]] <= nums[i]) {
                --tt;
            }
            q[++tt] = i;
            if (i >= k - 1) {
                result[resTop++] = nums[q[hh]];
            }
        }
        return result;
    }
}

