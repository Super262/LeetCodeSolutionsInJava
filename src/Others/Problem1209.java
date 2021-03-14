package Others;

import java.util.Stack;

public class Problem1209 {
    public String removeDuplicates(String s,final int k) {
        Stack<Character> letterStack = new Stack<>();
        Stack<Integer> counterStack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            if (!letterStack.empty() && letterStack.peek() == ch) {
                counterStack.push(counterStack.pop() + 1);
            } else {
                counterStack.push(1);
                letterStack.push(ch);
            }
            while (!letterStack.empty()) {
                if (counterStack.peek() >= k) {
                    counterStack.pop();
                    letterStack.pop();
                } else {
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!letterStack.empty()) {
            final char ch = letterStack.pop();
            final int factor = counterStack.pop();
            for (int j = 0; j < factor; j++) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.reverse().toString();
    }
}
