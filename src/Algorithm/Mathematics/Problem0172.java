package Algorithm.Mathematics;

public class Problem0172 {
    public int trailingZeroes(int n) {
        int currentBase = 5;
        int result = 0;
        int temp = n / currentBase;
        while (temp != 0) {
            result += temp;
            currentBase *= 5;
            temp = n / currentBase;
        }
        return result;
    }
}
