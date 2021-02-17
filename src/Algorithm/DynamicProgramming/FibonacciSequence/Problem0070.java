package Algorithm.DynamicProgramming.FibonacciSequence;

public class Problem0070 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int fn = 0;
        n = n - 2;
        while (n > 0) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
            --n;
        }
        return fn;
    }
}
