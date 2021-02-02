package Others;

public class Problem0641 {

    private static class MyCircularDeque {
        private final int[] data;
        private final int capacity;
        private int headIndex;
        private int tailIndex;
        private int count;

        public MyCircularDeque(int k) {
            this.capacity = k;
            this.data = new int[k];
            this.headIndex = this.tailIndex = this.count = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    data[0] = value;
                    headIndex = tailIndex = 0;
                } else {
                    headIndex = (headIndex - 1 + capacity) % capacity;
                    data[headIndex] = value;
                }
                ++count;
                return true;
            }
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    data[0] = value;
                    headIndex = tailIndex = 0;
                } else {
                    tailIndex = (tailIndex + 1) % capacity;
                    data[tailIndex] = value;
                }
                ++count;
                return true;
            }
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                if (count == 1) {
                    headIndex = tailIndex = 0;
                } else {
                    headIndex = (headIndex + 1) % capacity;
                }
                --count;
                return true;
            }
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                if (count == 1) {
                    headIndex = tailIndex = 0;
                } else {
                    tailIndex = (tailIndex - 1 + capacity) % capacity;
                }
                --count;
                return true;
            }
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return data[headIndex];
            }
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return data[tailIndex];
            }
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return count == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return count == capacity;
        }
    }
}
