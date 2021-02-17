package Algorithm.GreedyStrategy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem0435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals,Comparator.comparingInt(o -> o[1]));
        int result = 0;
        int[] prev = null;
        for (int[] current : intervals) {
            if (prev != null && current[0] < prev[1]) {
                ++result;
            } else {
                prev = current;
            }
        }
        return result;
    }
}
