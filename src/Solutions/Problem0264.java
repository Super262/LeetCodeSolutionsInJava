package Solutions;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Problem0264 {
    public int nthUglyNumber(int n) {
        HashSet<Long> visited = new HashSet<>(n);
        PriorityQueue<Long> heap = new PriorityQueue<>(n); // Long -> prevents overflow.
        long[] factors = {2,3,5};
        visited.add(1L);
        heap.add(1L);
        long currentVal = 0;
        for (int i = 0; i < n; ++i) {
            currentVal = heap.poll();
            for (long f : factors) {
                long nextValue = f * currentVal;
                if (visited.contains(nextValue)) {
                    continue;
                }
                visited.add(nextValue);
                heap.add(nextValue);
            }
        }
        return (int) currentVal;
    }
}
