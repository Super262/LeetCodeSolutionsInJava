package Solutions;

import java.util.Stack;

public class Problem0456 {
    public boolean find132pattern(final int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] preMinimal = new int[nums.length];
        Stack<Integer> minimalStack = new Stack<>();
        preMinimal[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            preMinimal[i] = Math.min(preMinimal[i - 1],nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] > preMinimal[i]) {
                while (!minimalStack.empty() && minimalStack.peek() <= preMinimal[i]) {
                    minimalStack.pop();
                }
                if (!minimalStack.empty() && minimalStack.peek() < nums[i]) {
                    return true;
                }
                minimalStack.push(nums[i]);
            }
        }
        return false;
    }
}
