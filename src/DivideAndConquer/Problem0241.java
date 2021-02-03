package DivideAndConquer;

import java.util.LinkedList;
import java.util.List;

public class Problem0241 {
    public List<Integer> diffWaysToCompute(String input) {
        LinkedList<Integer> result = new LinkedList<>();
        if (input == null) {
            return result;
        }
        int sLen = input.length();
        int i = 0;
        while (i < sLen) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                break;
            }
            ++i;
        }
        if (i >= sLen) {
            result.addLast(Integer.parseInt(input.substring(0,i)));
            return result;
        }
        while (i < sLen) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1,sLen));
                if (input.charAt(i) == '+') {
                    for (int l : left) {
                        for (int r : right) {
                            result.addLast(l + r);
                        }
                    }
                } else if (input.charAt(i) == '-') {
                    for (int l : left) {
                        for (int r : right) {
                            result.addLast(l - r);
                        }
                    }
                } else {
                    for (int l : left) {
                        for (int r : right) {
                            result.addLast(l * r);
                        }
                    }
                }
            }
            ++i;
        }
        return result;
    }
}
