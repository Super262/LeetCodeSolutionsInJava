package solutions.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Problem0503 {
    public int[] nextGreaterElements(final int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> minimalIndexStack = new Stack<>();
        Arrays.fill(result,-1);
        for(int j = 0; j < 2; ++j){
            for(int i = 0; i < nums.length; ++i){
                while(!minimalIndexStack.empty() && nums[minimalIndexStack.peek()] < nums[i]){
                    if(result[minimalIndexStack.peek()] == -1 ){
                        result[minimalIndexStack.peek()] = nums[i];
                    }
                    minimalIndexStack.pop();
                }
                minimalIndexStack.push(i);
            }
        }
        return result;
    }
}
