package Others;

import java.util.Stack;

public class Problem0071 {
    public String simplifyPath(String path) {
        path = path + "/";
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int len = path.length(), pointCount = 0, index = 0;
        while (index < len) {
            char c = path.charAt(index);
            if (c == '/') {
                if (pointCount == 2) {
                    // pop the first point, second point and the slash
                    while (pointCount-- >= 0 && !stack.empty()) {
                        stack.pop();
                    }
                    while (!stack.empty() && stack.peek() != '/') {
                        // pop the child directory
                        stack.pop();
                    }
                    pointCount = 0;
                } else if (pointCount == 1) {
                    // pop the first point and the slash
                    while (pointCount-- >= 0 && !stack.empty()) {
                        stack.pop();
                    }
                    pointCount = 0;
                } else {
                    while (!stack.empty() && stack.peek() == '/') {
                        stack.pop();
                    }
                    stack.push(c);
                    ++index;
                }
            } else {
                if (c == '.' && pointCount < 2) {
                    pointCount++;
                } else {
                    pointCount = 0;
                }
                stack.push(c);
                ++index;
            }
        }
        while (stack.size() > 1 && stack.peek() == '/') {
            stack.pop();
        }
        while (!stack.empty()) {
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
}
