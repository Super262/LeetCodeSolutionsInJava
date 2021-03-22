package Algorithm.DoublePointers;

import java.util.HashMap;

public class Problem0170 {
    private static class TwoSum {

        private final HashMap<Integer, Integer> count;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            count = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            count.put(number,count.getOrDefault(number,0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            int nums2;
            for (Integer nums1 : count.keySet()) {
                nums2 = value - nums1;
                if (nums1 == nums2 && count.getOrDefault(nums1,0) > 1) {
                    return true;
                }
                if (nums1 != nums2 && count.getOrDefault(nums2,0) > 0) {
                    return true;
                }
            }
            return false;
        }
    }

}
