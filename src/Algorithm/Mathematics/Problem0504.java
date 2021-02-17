package Algorithm.Mathematics;

public class Problem0504 {
    public String convertToBase7(int num) {
        boolean isNeg = false;
        if (num < 0) {
            num = -num;
            isNeg = true;
        }
        int digitsCount = 1;
        int maxBase = 1;
        while (num / maxBase >= 7) {
            maxBase *= 7;
            ++digitsCount;
        }
        char[] result;
        int resultTop;
        if (isNeg) {
            result = new char[digitsCount + 1];
            result[0] = '-';
            resultTop = 1;
        } else {
            result = new char[digitsCount];
            resultTop = 0;
        }
        int tempFactor;
        for (int i = 0; i < digitsCount; ++i) {
            tempFactor = num / maxBase;
            result[resultTop++] = (char) (tempFactor + (int) '0');
            num -= tempFactor * maxBase;
            maxBase /= 7;
        }
        return new String(result);
    }
}
