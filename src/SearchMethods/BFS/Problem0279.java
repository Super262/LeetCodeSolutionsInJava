package SearchMethods.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem0279 {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> q = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        int level = 0;
        q.add(n);
        int currentSize;
        int currentValue;
        int nextValue;
        while (!q.isEmpty()) {
            currentSize = q.size();
            ++level;
            while (currentSize > 0) {
                currentValue = q.poll();
                --currentSize;
                marked[currentValue] = true;
                for (int s : squares) {
                    nextValue = currentValue - s;
                    if (nextValue == 0) {
                        return level;
                    } else {
                        if (nextValue > 0 && !marked[nextValue]) {
                            q.add(nextValue);
                        }
                    }
                }
            }
        }
        return level;
    }

    private List<Integer> generateSquares(int n) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 1;
        while (result.isEmpty() || result.peekLast() < n) {
            result.addLast(i * i);
            ++i;
        }
        if (result.peekLast() > n) {
            result.removeLast();
        }
        return result;
    }
}
