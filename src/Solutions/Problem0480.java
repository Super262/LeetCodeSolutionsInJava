package Solutions;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem0480 {
    public double[] medianSlidingWindow(int[] nums,int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new double[0];
        }
        DualHeap dualHeap = new DualHeap();
        for (int i = 0; i < k; ++i) {
            dualHeap.add(nums[i]);
        }
        double[] result = new double[nums.length - k + 1];
        int resultTop = 0;
        result[resultTop++] = dualHeap.getMedian();
        for (int start = 1; start < nums.length - k + 1; ++start) {
            dualHeap.remove(nums[start - 1]);
            dualHeap.add(nums[start + k - 1]);
            result[resultTop++] = dualHeap.getMedian();
        }
        return result;
    }

    private static class DualHeap {
        final PriorityQueue<Integer> smallerNums;
        final PriorityQueue<Integer> largerNums;
        final HashMap<Integer, Integer> delayedRemovals;
        int smallerSize;
        int largerSize;

        public DualHeap() {
            smallerNums = new PriorityQueue<>((o1,o2) -> -o1.compareTo(o2));
            largerNums = new PriorityQueue<>(Integer::compareTo);
            delayedRemovals = new HashMap<>();
            smallerSize = 0;
            largerSize = 0;
        }

        private void cleanAndAlign(PriorityQueue<Integer> heap) {
            int peekValue;
            int remainsCount;
            while (!heap.isEmpty()) {
                peekValue = heap.peek();
                if (!delayedRemovals.containsKey(peekValue)) {
                    return;
                }
                remainsCount = delayedRemovals.get(peekValue);
                if (remainsCount == 1) {
                    delayedRemovals.remove(peekValue);
                } else {
                    delayedRemovals.put(peekValue,remainsCount - 1);
                }
                heap.poll();
            }
        }

        private void balanceTwoParts() {
            while (!largerNums.isEmpty() && smallerSize < largerSize) {
                smallerNums.offer(largerNums.poll());
                ++smallerSize;
                --largerSize;
                cleanAndAlign(largerNums);
            }
            while (!smallerNums.isEmpty() && smallerSize > largerSize + 1) {
                largerNums.offer(smallerNums.poll());
                --smallerSize;
                ++largerSize;
                cleanAndAlign(smallerNums);
            }
        }

        public void add(int num) {
            if (smallerNums.isEmpty() || num <= smallerNums.peek()) {
                smallerNums.add(num);
                ++smallerSize;
            } else {
                largerNums.add(num);
                ++largerSize;
            }
            balanceTwoParts();
        }

        public void remove(int num) {
            delayedRemovals.put(num,delayedRemovals.getOrDefault(num,0) + 1);
            if (!smallerNums.isEmpty() && num <= smallerNums.peek()) {
                --smallerSize;
                cleanAndAlign(smallerNums);
            } else if (!largerNums.isEmpty()) {
                --largerSize;
                cleanAndAlign(largerNums);
            }
            balanceTwoParts(); // This is very important!
        }

        private double getMedian() {
            if (smallerSize == largerSize && !smallerNums.isEmpty() && !largerNums.isEmpty()) {
                return ((double) smallerNums.peek() + (double) largerNums.peek()) / 2.0;
            } else if (!smallerNums.isEmpty()) {
                return smallerNums.peek();
            }
            return Double.MAX_VALUE;
        }
    }
}
