package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0946 {
    public boolean validateStackSequences(int[] pushed,int[] popped) {
        Stack<Integer> tempStack = new Stack<>();
        int pushedIt = 0;
        int poppedIt = 0;
        while (poppedIt != popped.length && pushedIt != pushed.length) {
            tempStack.push(pushed[pushedIt]);
            ++pushedIt;
            while (!tempStack.empty() && popped[poppedIt] == tempStack.peek()) {
                tempStack.pop();
                ++poppedIt;
            }
        }
        return poppedIt == popped.length && pushedIt == pushed.length && tempStack.empty();
    }
}
