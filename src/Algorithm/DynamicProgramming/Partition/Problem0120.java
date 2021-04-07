package Algorithm.DynamicProgramming.Partition;

import java.util.List;

public class Problem0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int y = 0; y < memo.length; ++y) {
            for (int x = 0; x < memo[0].length; ++x) {
                memo[y][x] = -1;
            }
        }
        return dpToGetSum(triangle,0,0,memo);
    }

    private int dpToGetSum(List<List<Integer>> triangle,int y,int x,int[][] memo) {
        if (y == triangle.size()) {
            return 0;
        }
        if (memo[y][x] != -1) {
            return memo[y][x];
        }
        int currentSum = triangle.get(y).get(x) + Math.min(dpToGetSum(triangle,y + 1,x,memo),dpToGetSum(triangle,y + 1,x + 1,memo));
        memo[y][x] = currentSum;
        return currentSum;
    }
}
