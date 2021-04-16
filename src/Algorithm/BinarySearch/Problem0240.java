package Algorithm.BinarySearch;

public class Problem0240 {
    public boolean searchMatrix(int[][] matrix,int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                ++col;
            } else {
                --row;
            }
        }
        return false;
    }
}
