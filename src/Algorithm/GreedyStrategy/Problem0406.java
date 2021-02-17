package Algorithm.GreedyStrategy;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem0406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people,(p1,p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1],p2[1]);
            } else {
                if (p1[0] > p2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        ArrayList<int[]> result = new ArrayList<>(people.length);
        for (int[] p : people) {
            result.add(p[1],p);
        }
        return result.toArray(new int[people.length][]);
    }
}
