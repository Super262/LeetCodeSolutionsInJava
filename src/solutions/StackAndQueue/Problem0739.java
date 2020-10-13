package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0739 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> temp = new Stack<>();
        for(int i = 0; i < T.length; ++i){
            while(!temp.empty() && T[temp.peek()] < T[i]){
                result[temp.peek()] = i - temp.peek();
                temp.pop();
            }
            temp.push(i);
        }
        result[temp.peek()] = 0;
        return result;
    }
}
