package Solutions;

import java.util.Arrays;

public class Problem0274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        Arrays.fill(counter,0);
        for (int ct : citations) {
            if (ct >= n) {
                ++counter[n];
            } else {
                ++counter[ct];
            }
        }
        int total = 0;
        for (int i = n; i >= 0; --i) {
            total += counter[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}
