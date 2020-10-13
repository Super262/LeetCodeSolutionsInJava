package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> temp = new Stack<>();
        int i = 0, j = 0;
        while(j < popped.length){
            while(temp.empty() || temp.peek() != popped[j]){
                if(i >= pushed.length){
                    return false;
                }
                else{
                    temp.push(pushed[i]);
                    ++i;
                }
            }
            temp.pop();
            ++j;
        }
        return temp.empty();
    }
}
