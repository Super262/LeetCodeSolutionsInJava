package Solutions;

public class Problem0402 {
    public String removeKdigits(final String num,final int k) {
        if (k == num.length()) {
            return "0";
        }
        int tempK = k;
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < num.length(); ++i) {
            char ch = num.charAt(i);
            while (tempK > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > ch) {
                stack.setLength(stack.length() - 1);
                --tempK;
            }
            stack.append(ch);
        }

        int zeroCount = 0;
        if (stack.length() > num.length() - k) {
            stack.setLength(num.length() - k);
        }
        for (int i = 0; i < stack.length(); ++i) {
            if (stack.charAt(i) == '0') {
                zeroCount++;
            } else {
                break;
            }
        }
        if (zeroCount == stack.length()) {
            return "0";
        } else {
            return stack.substring(zeroCount);
        }
    }
}
