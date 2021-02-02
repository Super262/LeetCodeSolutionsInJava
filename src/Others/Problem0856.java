package Others;

import java.util.Stack;

public class Problem0856 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> scores = new Stack<>();
        int result = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                scores.push(0);
            } else {
                int count = 0;
                while (!scores.empty() && scores.peek() != 0) {
                    count += scores.pop();
                }
                if (count == 0) {
                    scores.pop();
                    scores.push(1);
                } else {
                    scores.pop();
                    scores.push(2 * count);
                }
            }
        }
        while (!scores.empty()) {
            result += scores.pop();
        }
        return result;
    }
}
