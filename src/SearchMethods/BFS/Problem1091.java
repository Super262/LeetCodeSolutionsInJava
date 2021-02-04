package SearchMethods.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] directions = {{1,1},{0,1},{1,0},{-1,1},{1,-1},{0,-1},{-1,0},{-1,-1}};
        final int height = grid.length;
        final int width = grid[0].length;
        Queue<int[]> nodes = new LinkedList<>();

        nodes.add(new int[]{0,0});
        int pathLength = 0;
        int qSize;
        int[] currentNode;
        int nextY;
        int nextX;
        while (!nodes.isEmpty()) {
            qSize = nodes.size();
            ++pathLength;
            while (qSize > 0) {
                currentNode = nodes.poll();
                --qSize;
                if (grid[currentNode[0]][currentNode[1]] == 1) {
                    continue;
                }
                if (currentNode[0] == height - 1 && currentNode[1] == width - 1) {
                    return pathLength;
                } else {
                    grid[currentNode[0]][currentNode[1]] = 1;
                    for (int[] direction : directions) {
                        nextY = currentNode[0] + direction[0];
                        nextX = currentNode[1] + direction[1];
                        if (nextY >= 0 && nextY < height && nextX >= 0 && nextX < width) {
                            nodes.add(new int[]{nextY,nextX});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
