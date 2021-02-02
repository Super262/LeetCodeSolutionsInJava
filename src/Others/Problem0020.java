package Others;

import java.util.Stack;

public class Problem0020 {
    public boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')': {
                    if (!temp.empty() && temp.peek() == '(') {
                        temp.pop();
                    } else {
                        return false;
                    }
                    break;
                }
                case ']': {
                    if (!temp.empty() && temp.peek() == '[') {
                        temp.pop();
                    } else {
                        return false;
                    }
                    break;
                }
                case '}': {
                    if (!temp.empty() && temp.peek() == '{') {
                        temp.pop();
                    } else {
                        return false;
                    }
                    break;
                }
                default: {
                    temp.push(c);
                    break;
                }
            }
        }
        return temp.empty();
    }
}
