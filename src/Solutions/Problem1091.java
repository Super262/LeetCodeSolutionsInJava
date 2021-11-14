package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1091 {

    // 双向BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        if (grid.length == 1 && grid[0].length == 1) {
            return 1;
        }
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        int[][] directions = {{1,1},{0,1},{1,0},{-1,1},{1,-1},{0,-1},{-1,0},{-1,-1}};
        Queue<Point> forwardQueue = new LinkedList<>();
        Queue<Point> backwardQueue = new LinkedList<>();
        boolean[][] forwardVisited = new boolean[grid.length][grid[0].length];
        boolean[][] backwardVisited = new boolean[grid.length][grid[0].length];
        forwardVisited[0][0] = true;
        backwardVisited[backwardVisited.length - 1][backwardVisited[0].length - 1] = true;
        forwardQueue.add(new Point(0,0));
        backwardQueue.add(new Point(grid.length - 1,grid[0].length - 1));
        int distance = 1;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            ++distance;
            if (extendQueue(forwardQueue,grid,directions,forwardVisited,backwardVisited)) {
                return distance;
            }
            ++distance;
            if (extendQueue(backwardQueue,grid,directions,backwardVisited,forwardVisited)) {
                return distance;
            }
        }
        return -1;
    }

    private boolean extendQueue(Queue<Point> queue,int[][] grid,int[][] directions,boolean[][] currentVisited,boolean[][] oppositeVisited) {
        final int currentSize = queue.size();
        for (int i = 0; i < currentSize; ++i) {
            Point p = queue.poll();
            assert p != null;
            for (int[] d : directions) {
                Point nextP = new Point(p.x + d[0],p.y + d[1]);
                if (!isAvailablePoint(nextP,grid,currentVisited)) {
                    continue;
                }
                if (oppositeVisited[nextP.x][nextP.y]) {
                    return true;
                }
                queue.add(nextP);
                currentVisited[nextP.x][nextP.y] = true;
            }
        }
        return false;
    }

    private boolean isAvailablePoint(Point p,int[][] grid,boolean[][] visited) {
        if (p.x < 0 || p.x >= grid.length) {
            return false;
        }
        if (p.y < 0 || p.y >= grid[0].length) {
            return false;
        }
        if (grid[p.x][p.y] == 1) {
            return false;
        }
        return !visited[p.x][p.y];
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
