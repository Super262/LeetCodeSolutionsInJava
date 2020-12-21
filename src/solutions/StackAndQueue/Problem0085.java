package solutions.StackAndQueue;

public class Problem0085 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[] tempHeight = new int[matrix[0].length];
        int result = -1;
        for (char[] row : matrix) {
            for (int j = 0; j < row.length; ++j) {
                if (row[j] == '1') {
                    ++tempHeight[j];
                } else {
                    tempHeight[j] = 0;
                }
            }
            result = Math.max(largestRectangleArea(tempHeight),result);
        }
        return result;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        if (heights.length == 1){
            return heights[0];
        }
        int[] stack = new int[heights.length];
        int stackSize = 0, stackPeek = -1;
        int result = -1;
        int[] leftLessEleIndex = new int[heights.length];
        int[] rightLessEleIndex = new int[heights.length];
        for (int i = 0; i < heights.length; ++i){
            while (stackSize != 0 && heights[stack[stackPeek]] >= heights[i]){
                --stackPeek;
                --stackSize;
            }
            if(stackSize == 0){
                leftLessEleIndex[i] = -1;
            }
            else{
                leftLessEleIndex[i] = stack[stackPeek];
            }
            stack[++stackPeek] = i;
            ++stackSize;
        }
        stackSize = 0;
        stackPeek = -1;
        for (int i = heights.length - 1; i >= 0 ; --i){
            while (stackSize != 0  && heights[stack[stackPeek]] >= heights[i]){
                --stackPeek;
                --stackSize;
            }
            if(stackSize == 0){
                rightLessEleIndex[i] = heights.length;
            }
            else{
                rightLessEleIndex[i] = stack[stackPeek];
            }
            stack[++stackPeek] = i;
            ++stackSize;
        }
        for (int i = 0; i < heights.length; ++i){
            result = Math.max(result, heights[i] * (rightLessEleIndex[i] - leftLessEleIndex[i] - 1));
        }
        return result;
    }
}
