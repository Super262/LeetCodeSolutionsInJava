package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0921 {
    public int minAddToMakeValid(String S) {
        final Stack<Character> stack = new Stack<>();
        final int strLength = S.length();
        int remainderCount = 0;
        for (int i = 0; i < strLength; ++i) {
            char ch = S.charAt(i);
            if (!stack.empty() && ch == ')' && stack.peek() == '(') {
                stack.pop();
                --remainderCount;
            } else {
                stack.push(ch);
                ++remainderCount;
            }
        }
        return remainderCount;
    }
}
