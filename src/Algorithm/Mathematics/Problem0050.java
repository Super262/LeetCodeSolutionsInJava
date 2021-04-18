package Algorithm.Mathematics;

public class Problem0050 {
    public double myPow(double x,int n) {
        if (n == 0) {
            return 1;
        }
        boolean isNegPower = n < 0;
        n = Math.abs(n);
        double result = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                result *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return isNegPower ? 1 / result : result;
    }
}
