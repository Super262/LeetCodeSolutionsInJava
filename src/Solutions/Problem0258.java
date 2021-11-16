package Solutions;

public class Problem0258 {
    public int addDigits(final int num) {
        if (num == 0) {
            return num;
        }
        if (num % 9 != 0) {
            return num % 9;
        }
        return 9;
    }
}
