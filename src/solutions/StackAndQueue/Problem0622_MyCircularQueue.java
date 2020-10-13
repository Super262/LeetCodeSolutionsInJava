package solutions.StackAndQueue;

class Problem0622_MyCircularQueue {

    private final int capacity;
    private final int[] data;
    private int count;
    private int headIndex;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public Problem0622_MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.count = 0;
        this.headIndex = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            data[(headIndex + count) % capacity] = value;
            ++count;
            return true;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            headIndex = (headIndex + 1) % capacity;
            --count;
            return true;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(headIndex + count - 1) % capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.count == this.capacity;
    }
}
