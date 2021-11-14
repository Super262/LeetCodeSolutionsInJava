package Solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new LinkedList<>();
        }
        boolean[][] canReachA = new boolean[matrix.length][matrix[0].length];
        boolean[][] canReachP = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            exploreArea(canReachP,matrix,i,0,-1);
            exploreArea(canReachA,matrix,i,matrix[0].length - 1,-1);
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            exploreArea(canReachP,matrix,0,i,-1);
            exploreArea(canReachA,matrix,matrix.length - 1,i,-1);
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int y = 0; y < matrix.length; ++y) {
            for (int x = 0; x < matrix[0].length; ++x) {
                if (canReachA[y][x] && canReachP[y][x]) {
                    result.add(Arrays.asList(y,x));
                }
            }
        }
        return result;
    }

    private void exploreArea(boolean[][] canReach,int[][] matrix,int endY,int endX,int nextHeight) {
        if (endY < 0 || endY >= matrix.length || endX < 0 || endX >= matrix[0].length || canReach[endY][endX]) {
            return;
        }
        if (matrix[endY][endX] >= nextHeight) {
            canReach[endY][endX] = true;
            exploreArea(canReach,matrix,endY + 1,endX,matrix[endY][endX]);
            exploreArea(canReach,matrix,endY - 1,endX,matrix[endY][endX]);
            exploreArea(canReach,matrix,endY,endX + 1,matrix[endY][endX]);
            exploreArea(canReach,matrix,endY,endX - 1,matrix[endY][endX]);
        }
    }
}
