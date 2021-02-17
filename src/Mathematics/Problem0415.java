package Mathematics;

public class Problem0415 {
    public String addStrings(String a,String b) {
        final int aLen = a.length();
        final int bLen = b.length();
        StringBuilder result = new StringBuilder(Math.max(aLen,bLen) + 1);
        boolean hasCarry = false;
        int i = aLen - 1;
        int j = bLen - 1;
        int tempSum;
        while (i >= 0 && j >= 0) {
            tempSum = (a.charAt(i) - '0') + (b.charAt(j) - '0');
            hasCarry = appendDigit(hasCarry,tempSum,result);
            --i;
            --j;
        }
        while (i >= 0) {
            tempSum = a.charAt(i) - '0';
            hasCarry = appendDigit(hasCarry,tempSum,result);
            --i;
        }
        while (j >= 0) {
            tempSum = b.charAt(j) - '0';
            hasCarry = appendDigit(hasCarry,tempSum,result);
            --j;
        }
        if (hasCarry) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    private boolean appendDigit(boolean hasCarry,int tempSum,StringBuilder result) {
        tempSum += hasCarry ? 1 : 0;
        if (tempSum > 9) {
            result.append((char) ('0' + tempSum - 10));
            return true;
        } else {
            result.append((char) ('0' + tempSum));
            return false;
        }
    }
}
