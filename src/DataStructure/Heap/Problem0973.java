package DataStructure.Heap;

public class Problem0973 {
    public int[][] kClosest(int[][] points,int k) {
        int[][] pointsCopied = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            pointsCopied[i] = new int[2];
            pointsCopied[i][0] = points[i][0];
            pointsCopied[i][1] = points[i][1];
        }
        quickSelectKth(pointsCopied,0,pointsCopied.length - 1,k);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = new int[2];
            result[i][0] = pointsCopied[i][0];
            result[i][1] = pointsCopied[i][1];
        }
        return result;
    }

    private void quickSelectKth(int[][] points,int startIndex,int endIndex,int k) {
        if (startIndex >= endIndex) {
            return;
        }
        int i = startIndex;
        int j = endIndex;
        int pivotDis = getDistance(points[startIndex + (endIndex - startIndex) / 2]);
        while (i <= j) {
            while (i <= j && getDistance(points[i]) < pivotDis) {
                i++;
            }
            while (i <= j && getDistance(points[j]) > pivotDis) {
                j--;
            }
            if (i <= j) {
                int[] tmp = points[j];
                points[j] = points[i];
                points[i] = tmp;
                i++;
                j--;
            }
        }
        if (startIndex + k - 1 <= j) {
            quickSelectKth(points,startIndex,j,k);
            return;
        }
        if (startIndex + k - 1 >= i) {
            quickSelectKth(points,i,endIndex,k - (i - startIndex));
        }
    }

    private int getDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
