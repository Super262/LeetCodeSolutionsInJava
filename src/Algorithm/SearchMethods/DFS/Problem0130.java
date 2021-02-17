package Algorithm.SearchMethods.DFS;

public class Problem0130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            clean(board,i,0);
            clean(board,i,board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; ++i) {
            clean(board,0,i);
            clean(board,board.length - 1,i);
        }
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[0].length; ++x) {
                if (board[y][x] == 'O') {
                    board[y][x] = 'X';
                } else if (board[y][x] == 'A') {
                    board[y][x] = 'O';
                }
            }
        }
    }

    private void clean(char[][] board,int startY,int startX) {
        if (startY < 0 || startY >= board.length || startX < 0 || startX >= board[0].length || board[startY][startX] != 'O') {
            return;
        }
        board[startY][startX] = 'A';
        clean(board,startY + 1,startX);
        clean(board,startY - 1,startX);
        clean(board,startY,startX + 1);
        clean(board,startY,startX - 1);
    }
}
