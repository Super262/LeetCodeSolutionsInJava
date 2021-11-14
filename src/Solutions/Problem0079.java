package Solutions;

public class Problem0079 {
    public boolean exist(char[][] board,String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        char[] wordStr = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[0].length; ++x) {
                if (board[y][x] == wordStr[0] && !visited[y][x]) {
                    if (pathIsWord(board,visited,wordStr,y,x,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean pathIsWord(char[][] board,boolean[][] visited,char[] word,final int boardY,final int boardX,final int wStart) {
        if (boardY < 0 || boardY >= board.length || boardX < 0 || boardX >= board[0].length || visited[boardY][boardX] || wStart >= word.length || word[wStart] != board[boardY][boardX]) {
            return false;
        } else {
            visited[boardY][boardX] = true;
            if (wStart == word.length - 1) {
                return true;
            } else {
                if (pathIsWord(board,visited,word,boardY,boardX + 1,wStart + 1) || pathIsWord(board,visited,word,boardY,boardX - 1,wStart + 1) || pathIsWord(board,visited,word,boardY + 1,boardX,wStart + 1) || pathIsWord(board,visited,word,boardY - 1,boardX,wStart + 1)) {
                    return true;
                } else {
                    visited[boardY][boardX] = false;
                    return false;
                }
            }
        }
    }
}
