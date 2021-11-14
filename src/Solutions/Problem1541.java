package Solutions;


public class Problem1541 {
    public int minInsertions(String s) {
        int result = 0, left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    ++i;
                } else {
                    ++result;
                }
                if (left > 0) {
                    left--;
                } else {
                    ++result;
                }
            }
        }
        result += 2 * left;
        return result;
    }
}
