package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Problem0200 {

    // Using DFS may make the stack overflow!

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int connectedCount = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == '0' || visited[y][x]) {
                    continue;
                }
                bfs(grid,visited,directions,y,x);
                ++connectedCount;
            }
        }
        return connectedCount;
    }

    private void bfs(char[][] grid,boolean[][] visited,int[][] directions,int startY,int startX) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY,startX});
        visited[startY][startX] = true;
        int currentSize;
        int[] currentNode;
        int nextX;
        int nextY;
        while (!q.isEmpty()) {
            currentSize = q.size();
            for (int i = 0; i < currentSize; ++i) {
                currentNode = q.poll();
                for (int[] d : directions) {
                    assert currentNode != null;
                    nextY = currentNode[0] + d[0];
                    nextX = currentNode[1] + d[1];
                    if (nextY < 0 || nextY >= grid.length || nextX < 0 || nextX >= grid[0].length || grid[nextY][nextX] == '0' || visited[nextY][nextX]) {
                        continue;
                    }
                    q.add(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }
}
