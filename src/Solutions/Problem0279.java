package Solutions;

public class Problem0279 {
    public int numSquares(int n) {
        if (checkNum(n)) {
            return 1;
        }
        for (int x = 1; x <= n / x; ++x) {
            if (checkNum(n - x * x)) {
                return 2;
            }
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 != 7) {
            return 3;
        }
        return 4;
    }

    private boolean checkNum(int x) {
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }
}
