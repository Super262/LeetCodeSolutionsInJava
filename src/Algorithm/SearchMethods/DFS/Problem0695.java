package Algorithm.SearchMethods.DFS;

public class Problem0695 {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == 1) {
                    result = Math.max(result,getArea(grid,y,x));
                }
            }
        }
        return result;
    }

    private int getArea(int[][] grid,final int startY,final int startX) {
        if (startY < 0 || startX < 0 || startY >= grid.length || startX >= grid[0].length || grid[startY][startX] == 0) {
            return 0;
        }
        grid[startY][startX] = 0;
        return 1 + getArea(grid,startY + 1,startX) + getArea(grid,startY - 1,startX) + getArea(grid,startY,startX + 1) + getArea(grid,startY,startX - 1);
    }
}
