package Solutions;

public class Problem0231 {
    public boolean isPowerOfTwo(final int n) {
        return n > 0 && (n & -n) == n;
    }
}
