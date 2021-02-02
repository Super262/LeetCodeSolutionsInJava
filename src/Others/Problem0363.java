package Others;

public class Problem0363 {
    public int maxSumSubmatrix(int[][] matrix,int k) {
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }
        final int rowsCount = matrix.length;
        final int colsCount = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int start = 0; start < colsCount; ++start) {
            final int[] tempRowSum = new int[rowsCount];
            for (int end = start; end < colsCount; ++end) {
                for (int i = 0; i < rowsCount; ++i) {
                    tempRowSum[i] += matrix[i][end];
                }
                result = Math.max(result,getMaxSumOfSubSeq(tempRowSum,k));
            }
        }
        return result;
    }

    private int getMaxSumOfSubSeq(final int[] seq,final int upperBound) {
        int result = Integer.MIN_VALUE;
        for (int start = 0; start < seq.length; ++start) {
            int subSum = 0;
            for (int end = start; end < seq.length; ++end) {
                subSum += seq[end];
                if (subSum > result && subSum <= upperBound) {
                    result = subSum;
                }
            }
        }
        return result;
    }
}
