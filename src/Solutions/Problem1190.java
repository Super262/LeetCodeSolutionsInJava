package Solutions;

import java.util.Stack;

public class Problem1190 {
    public String reverseParentheses(String s) {
        Stack<Character> dataStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ')') {
                StringBuilder temp = new StringBuilder();
                while (dataStack.peek() != '(') {
                    temp.append(dataStack.pop());
                }
                dataStack.pop();
                for (int j = 0; j < temp.length(); ++j) {
                    dataStack.push(temp.charAt(j));
                }
            } else {
                dataStack.push(ch);
            }
        }
        while (!dataStack.empty()) {
            result.insert(0,dataStack.pop());
        }
        return result.toString();
    }
}
