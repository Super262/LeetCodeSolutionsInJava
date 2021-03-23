package Algorithm.DoublePointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0018 {
    public List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums == null) {
            return results;
        }
        int boundD = nums.length;
        if (boundD < 4) {
            return results;
        }
        int boundB = boundD - 2;
        int boundA = boundB - 1;
        Arrays.sort(nums);
        for (int a = 0; a < boundA; ++a) {
            if (a > 0 && nums[a - 1] == nums[a]) {
                continue;
            }
            for (int b = a + 1; b < boundB; ++b) {
                if (b > a + 1 && nums[b - 1] == nums[b]) {
                    continue;
                }
                twoSum(nums,b + 1,boundD,target - nums[a] - nums[b],nums[a],nums[b],results);
            }
        }
        return results;
    }

    private void twoSum(final int[] nums,final int start,final int end,final int target,final int prefix1,final int prefix2,final List<List<Integer>> results) {
        if (start >= end - 1) {
            return;
        }
        int left = start;
        int right = end - 1;
        int tempSum;
        while (left < right) {
            tempSum = nums[left] + nums[right];
            if (tempSum == target) {
                LinkedList<Integer> tempList = new LinkedList<>();
                tempList.add(prefix1);
                tempList.add(prefix2);
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
