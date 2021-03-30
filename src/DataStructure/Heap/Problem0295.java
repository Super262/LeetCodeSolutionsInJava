package DataStructure.Heap;

import java.util.PriorityQueue;

public class Problem0295 {
    private static class MedianFinder {

        private final PriorityQueue<Integer> maxHeap;
        private final PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1,o2) -> -o1.compareTo(o2));
            minHeap = new PriorityQueue<>(Integer::compareTo);
        }

        public void addNum(int num) {
            if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            balance();
        }

        public double findMedian() {
            if (maxHeap.isEmpty()) {
                return 0;
            }
            if (maxHeap.size() == minHeap.size()) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return (double) maxHeap.peek();
        }

        private void balance() {
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }
}
