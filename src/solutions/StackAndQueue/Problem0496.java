package solutions.StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

public class Problem0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> nums2NextGreaterElements = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int j : nums2) {
            while (!stack.empty() && stack.peek() < j) {
                nums2NextGreaterElements.put(stack.peek(),j);
                stack.pop();
            }
            stack.push(j);
            nums2NextGreaterElements.put(j,-1);
        }
        for(int i = 0; i < nums1.length; ++i){
            Integer ngte = nums2NextGreaterElements.get(nums1[i]);
            result[i] = (ngte == null? -1 : ngte );
        }
        return result;
    }
}
