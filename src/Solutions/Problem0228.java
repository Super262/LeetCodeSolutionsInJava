package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem0228 {
    public List<String> summaryRanges(final int[] nums) {
        List<String> result = new LinkedList<>();
        for (int l = 0; l < nums.length; ++l) {
            int r = l + 1;
            while (r < nums.length && nums[r - 1] + 1 == nums[r]) {
                ++r;
            }
            if (r == l + 1) {  // 区间只有1个数字
                result.add("" + nums[l]);
            } else {
                result.add(nums[l] + "->" + nums[r - 1]);
            }
            l = r - 1;
        }
        return result;
    }
}
