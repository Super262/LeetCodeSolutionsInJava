package solutions.StackAndQueue;

public class Problem1381 {

    private static class CustomStack {
        private final int maxSize;
        private final int[] data;
        private int topIndex;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            topIndex = -1;
            data = new int[this.maxSize];
        }

        public void push(int x) {
            if (topIndex != maxSize - 1) {
                data[++topIndex] = x;
            }
        }

        public int pop() {
            return topIndex < 0 ? -1 : data[topIndex--];
        }

        public void increment(int k,int val) {
            if (topIndex >= 0) {
                for (int i = topIndex + 1 > k ? k - 1 : topIndex; i >= 0; --i) {
                    data[i] += val;
                }
            }
        }
    }

}