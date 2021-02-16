package Mathematics;

public class Problem0168 {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            --n;
            result.append((char)('A' + n % 26));
            n /= 26;
        } return result.reverse().toString();
    }
}
