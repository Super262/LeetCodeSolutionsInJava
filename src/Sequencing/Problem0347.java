package Sequencing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem0347 {
    public int[] topKFrequent(int[] nums,int k) {
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        int curFreq;
        for (int num : nums) {
            curFreq = 1;
            if (numToFreq.containsKey(num)) {
                curFreq += numToFreq.get(num);
            }
            numToFreq.put(num,curFreq);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(numToFreq::get));
        for (int num : numToFreq.keySet()) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if (numToFreq.get(pq.peek()) < numToFreq.get(num)) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.stream().mapToInt(Integer::valueOf).toArray();
    }
}
