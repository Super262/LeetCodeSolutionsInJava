package Algorithm.GreedyStrategy;

public class Problem0402 {
    public String removeKdigits(final String num,final int k) {
        if (num == null || num.isEmpty()) {
            return "0";
        }
        int numLen = num.length();
        if (k >= numLen) {
            return "0";
        }
        int deletedCount = k;
        char[] stack = new char[numLen];
        int stackTop = -1;
        char digit;
        for (int i = 0; i < numLen; ++i) {
            digit = num.charAt(i);
            while (stackTop >= 0 && deletedCount > 0 && stack[stackTop] > digit) {
                --stackTop;
                --deletedCount;
            }
            if (digit == '0' && stackTop == -1) {
                continue;
            }
            stack[++stackTop] = digit;
        }
        if (stackTop == -1) {
            return "0";
        }
        return String.valueOf(stack,0,Math.min(numLen - k,stackTop + 1));
    }
}
