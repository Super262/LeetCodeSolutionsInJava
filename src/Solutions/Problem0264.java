package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem0264 {
    public int nthUglyNumber(int n) {
        List<Integer> result = new ArrayList<>(n);
        result.add(1);
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (result.size() < n) {
            int r1 = result.get(p1) * 2;
            int r2 = result.get(p2) * 3;
            int r3 = result.get(p3) * 5;
            int minimal = Math.min(r1,Math.min(r2,r3));
            result.add(minimal);
            if (r1 == minimal) {
                ++p1;
            }
            if (r2 == minimal) {
                ++p2;
            }
            if (r3 == minimal) {
                ++p3;
            }
        }
        return result.get(n - 1);
    }
}
