package Algorithm.SearchMethods.DFS;

import java.util.ArrayList;

public class Problem0037 {
    private boolean valid;
    private boolean[][][] block;
    private boolean[][] column;
    private boolean[][] row;
    private ArrayList<int[]> blanks;

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        block = new boolean[9][9][9];
        column = new boolean[9][9];
        row = new boolean[9][9];
        blanks = new ArrayList<>();
        valid = false;
        int digit;
        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                if (board[y][x] == '.') {
                    blanks.add(new int[]{y,x});
                } else {
                    digit = (board[y][x] - '0') - 1;
                    column[x][digit] = true;
                    row[y][digit] = true;
                    block[y / 3][x / 3][digit] = true;
                }
            }
        }
        dfsToTest(board,0);
    }

    private void dfsToTest(char[][] board,final int blankIndex) {
        if (blankIndex == blanks.size()) {
            valid = true;
        } else {
            int[] blankPos = blanks.get(blankIndex);
            int y = blankPos[0];
            int x = blankPos[1];
            for (int digit = 0; digit < 9 && !valid; ++digit) {
                if (!block[y / 3][x / 3][digit] && !row[y][digit] && !column[x][digit]) {
                    board[y][x] = (char) ('0' + digit + 1);
                    block[y / 3][x / 3][digit] = true;
                    row[y][digit] = true;
                    column[x][digit] = true;
                    dfsToTest(board,blankIndex + 1);
                    block[y / 3][x / 3][digit] = false;
                    row[y][digit] = false;
                    column[x][digit] = false;
                }
            }
        }
    }
}
