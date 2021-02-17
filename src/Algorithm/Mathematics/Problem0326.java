package Algorithm.Mathematics;

public class Problem0326 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
