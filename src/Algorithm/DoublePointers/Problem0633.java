package Algorithm.DoublePointers;

public class Problem0633 {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        int tempSum;
        while (a <= b) {
            tempSum = a * a + b * b;
            if (tempSum == c) {
                return true;
            } else if (tempSum > c) {
                --b;
            } else {
                ++a;
            }
        }
        return false;
    }
}
