package Solutions;

public class Problem0367 {
    // Use subtraction instead of addition to prevent overflow!
    public boolean isPerfectSquare(int num) {
        int dis = 1;
        while (num > 0) {
            num -= dis;
            dis += 2;
        }
        return num == 0;
    }
}
