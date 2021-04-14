package DataStructure.Stack;

public class Problem0251 {
    private static class Vector2D {
        private int[][] vec;
        private int currentRow;
        private int currentCol;

        public Vector2D(int[][] vec) {
            if (vec == null) {
                return;
            }
            this.vec = vec;
            currentRow = 0;
            currentCol = 0;
        }

        public int next() {
            int result = Integer.MIN_VALUE;
            if (hasNext()) {
                result = vec[currentRow][currentCol];
                currentCol += 1;
            }
            return result;
        }

        public boolean hasNext() {
            if (vec == null) {
                return false;
            }
            while (currentRow < vec.length && currentCol >= vec[currentRow].length) {
                ++currentRow;
                currentCol = 0;
            }
            return currentRow < vec.length;
        }
    }
}
