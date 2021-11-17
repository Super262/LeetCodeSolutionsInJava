package Solutions;

public class Problem0289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        final int m = board.length;
        final int n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int livingOnes = 0;
                for (int di = -1; di <= 1; ++di) {
                    for (int dj = -1; dj <= 1; ++dj) {
                        int ni = i + di;
                        int nj = j + dj;
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                            continue;
                        }
                        if (ni == i && nj == j) {
                            continue;
                        }
                        livingOnes += (board[ni][nj] & 1);
                    }
                }
                if ((board[i][j] & 1) == 1) {
                    if (livingOnes < 2 || livingOnes > 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 3;
                    }
                } else {
                    if (livingOnes == 3) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] >>= 1;
            }
        }
    }
}
