package Algorithm.DoublePointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {

            // Don't forget this part!
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            twoSum(nums,i + 1,nums.length - 1,-nums[i],results);
        }
        return results;
    }

    private void twoSum(final int[] nums,final int start,final int end,final int target,final List<List<Integer>> results) {
        if (start < 0 || end >= nums.length || start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int tempSum;
        while (left < right) {
            tempSum = nums[left] + nums[right];
            if (tempSum == target) {
                LinkedList<Integer> tempList = new LinkedList<>();
                tempList.add(-target);
                tempList.add(nums[left]);
                tempList.add(nums[right]);
                results.add(tempList);
                --right;
                ++left;

                // Don't forget this part!
                while (left > 0 && left < right && nums[left - 1] == nums[left]) {
                    ++left;
                }

            } else if (tempSum > target) {
                --right;
            } else {
                ++left;
            }
        }
    }
}
