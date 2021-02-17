package Algorithm.SearchMethods.DFS;

public class Problem0200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == '1') {
                    exploreArea(grid,y,x);
                    ++result;
                }
            }
        }
        return result;
    }

    private void exploreArea(char[][] grid,final int startY,final int startX) {
        if (startY < 0 || startX < 0 || startY >= grid.length || startX >= grid[0].length || grid[startY][startX] == '0') {
            return;
        }
        grid[startY][startX] = '0';
        exploreArea(grid,startY + 1,startX);
        exploreArea(grid,startY - 1,startX);
        exploreArea(grid,startY,startX + 1);
        exploreArea(grid,startY,startX - 1);
    }
}
