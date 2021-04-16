package Algorithm.BinarySearch;

public class Problem0074 {
    public boolean searchMatrix(int[][] matrix,int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int mid;
        int pivot;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            pivot = getNumInMatrix(matrix,mid);
            if (pivot == target) {
                return true;
            } else if (target < pivot) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (getNumInMatrix(matrix,start) == target) {
            return true;
        }
        return getNumInMatrix(matrix,end) == target;
    }

    private int getNumInMatrix(int[][] matrix,int index) {
        return matrix[index / matrix[0].length][index % matrix[0].length];
    }
}
