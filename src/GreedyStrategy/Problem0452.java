package GreedyStrategy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem0452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null) {
            return 0;
        }
        if (points.length < 2) {
            return points.length;
        }
        Arrays.sort(points,Comparator.comparingInt(o -> o[1]));
        int result = 0;
        int[] prev = null;
        for (int[] current : points) {
            if (prev != null && prev[1] >= current[0]) {
                ++result;
            } else {
                prev = current;
            }
        }
        return result;
    }
}
