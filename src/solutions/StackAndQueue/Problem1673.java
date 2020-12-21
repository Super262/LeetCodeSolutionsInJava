package solutions.StackAndQueue;

import java.util.Stack;

public class Problem1673 {
    public int[] mostCompetitive(int[] nums, final int k) {
        if (nums.length <= k){
            return nums;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; ++i){
            while (!stack.empty() && stack.peek() > nums[i] && stack.size() + nums.length - i > k){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        while (stack.size() > k){
            stack.pop();
        }
        return stack.stream().mapToInt(Integer::valueOf).toArray();
    }
}
