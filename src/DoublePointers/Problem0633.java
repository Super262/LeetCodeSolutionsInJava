package DoublePointers;

public class Problem0633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        int tempSum;
        while (i >= 0 && i <= j) {
            tempSum = i * i + j * j;
            if (tempSum == c) {
                return true;
            } else if (tempSum > c) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }
}
