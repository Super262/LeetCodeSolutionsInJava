package Others;

import java.util.Stack;

public class Problem1003 {
    public boolean isValid(String s) {
        Stack<String> temp = new Stack<>();
        int length = s.length();
        char[] strArray = s.toCharArray();
        for (int i = 0; i < length; ++i) {
            char c = strArray[i];
            if (i < length - 1) {
                switch (c) {
                    case 'a': {
                        if (strArray[i + 1] == 'b') {
                            temp.push("ab");
                            ++i;
                        } else {
                            temp.push("a");
                        }
                        break;
                    }
                    case 'b': {
                        if (strArray[i + 1] == 'c' && !temp.empty() && temp.peek().equals("a")) {
                            temp.pop();
                            ++i;
                        } else if (!temp.empty() && temp.peek().equals("a")) {
                            temp.pop();
                            temp.push("ab");
                        } else {
                            return false;
                        }
                        break;
                    }
                    default: {
                        if (!temp.empty() && temp.peek().equals("ab")) {
                            temp.pop();
                        } else {
                            return false;
                        }
                        break;
                    }
                }
            } else {
                if (strArray[i] == 'c' && !temp.empty() && temp.peek().equals("ab")) {
                    temp.pop();
                } else {
                    return false;
                }
            }
        }
        return temp.empty();
    }
}
