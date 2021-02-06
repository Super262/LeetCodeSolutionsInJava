package SearchMethods.BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem0051 {
    private boolean[] rowFilled;
    private boolean[] columnFilled;
    private boolean[] diagonal135Filled;
    private boolean[] diagonal45Filled;
    private char[][] board;
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new LinkedList<>();
        rowFilled = new boolean[n];
        columnFilled = new boolean[n];
        diagonal135Filled = new boolean[2 * n - 1];
        diagonal45Filled = new boolean[2 * n - 1];
        board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars,'.');
        }
        dfsToTest(0);
        return result;
    }

    private void dfsToTest(final int currentRow) {
        if (currentRow == board.length) {
            generateResult();
        } else {
            for (int col = 0; col < board[0].length; ++col) {
                if (isEmpty(currentRow,col)) {
                    setFilled(currentRow,col);
                    dfsToTest(currentRow + 1);
                    setEmpty(currentRow,col);
                }
            }
        }

    }

    private boolean isEmpty(int y,int x) {
        return board[y][x] == '.' && !rowFilled[y] && !columnFilled[x] && !diagonal135Filled[y - x + (board.length - 1)] && !diagonal45Filled[y + x];
    }

    private void setFilled(int y,int x) {
        board[y][x] = 'Q';
        rowFilled[y] = true;
        columnFilled[x] = true;
        diagonal135Filled[y - x + (board.length - 1)] = true;
        diagonal45Filled[y + x] = true;
    }

    private void setEmpty(int y,int x) {
        board[y][x] = '.';
        rowFilled[y] = false;
        columnFilled[x] = false;
        diagonal135Filled[y - x + (board.length - 1)] = false;
        diagonal45Filled[y + x] = false;
    }

    private void generateResult() {
        List<String> temp = new LinkedList<>();
        for (char[] chArray : board) {
            temp.add(new String(chArray));
        }
        result.add(temp);
    }
}
