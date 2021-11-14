package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem0229 {
    public List<Integer> majorityElement(int[] nums) {
        int vote1 = 0;
        int vote2 = 0;
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        for (int num : nums) {
            if (candidate1 == num) {
                ++vote1;
                continue;
            }
            if (candidate2 == num) {
                ++vote2;
                continue;
            }
            if (vote1 == 0) {
                vote1 = 1;
                candidate1 = num;
                continue;
            }
            if (vote2 == 0) {
                vote2 = 1;
                candidate2 = num;
                continue;
            }
            --vote1;
            --vote2;
        }
        vote1 = 0;
        vote2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                ++vote1;
            } else if (num == candidate2) {
                ++vote2;
            }
        }
        List<Integer> result = new LinkedList<>();
        if (vote1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (vote2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}
