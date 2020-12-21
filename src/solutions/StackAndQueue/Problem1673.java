package solutions.StackAndQueue;

import java.util.Stack;

public class Problem1673 {
    public int[] mostCompetitive(int[] nums, final int k) {
        if (nums.length <= k){
            return nums;
        }
        final int[] stack = new int[k];
        int stackSize = 0;
        int stackPeek = -1;
        for (int i = 0; i < nums.length; ++i){
            while (stackSize > 0 && stack[stackPeek] > nums[i] && stackSize + nums.length - i > k){
                --stackPeek;
                --stackSize;
            }
            if (stackPeek < k - 1){
                stack[++stackPeek] = nums[i];
                ++stackSize;
            }
        }
        return stack;
    }
}
