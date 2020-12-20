package solutions.StackAndQueue;

import java.util.Stack;

public class Problem0921 {
    public int minAddToMakeValid(String S) {
        final Stack<Character> stack = new Stack<>();
        final int strLength = S.length();
        for (int i = 0; i < strLength; ++i){
            char ch = S.charAt(i);
            if(!stack.empty() && ch == ')' && stack.peek() == '('){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
