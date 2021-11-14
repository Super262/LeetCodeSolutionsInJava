package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem0233 {
    public int countDigitOne(int n) {
        // https://www.acwing.com/solution/content/20063/
        List<Integer> digits = new ArrayList<>(10);
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        int result = 0;
        for (int i = 0; i < digits.size(); ++i) {
            int rightNum = 0;
            int leftNum = 0;
            int rightBase = 1;
            for (int j = 0; j < i; ++j) {
                leftNum = leftNum * 10 + digits.get(j);
            }
            for (int j = i + 1; j < digits.size(); ++j) {
                rightNum = rightNum * 10 + digits.get(j);
                rightBase *= 10;
            }
            if (digits.get(i) == 0) {
                result += leftNum * rightBase;
            } else if (digits.get(i) == 1) {
                result += leftNum * rightBase + rightNum + 1;
            } else {
                result += (leftNum + 1) * rightBase;
            }
        }
        return result;
    }
}
