package Solutions;

import java.util.*;

public class Problem1086 {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> idToHeap = new HashMap<>();
        for (int[] stu : items) {
            PriorityQueue<Integer> pq = idToHeap.getOrDefault(stu[0],null);
            if (pq == null) {
                pq = new PriorityQueue<>(5);
                idToHeap.put(stu[0],pq);
            }
            pq.add(stu[1]);
            if (pq.size() > 5) {
                pq.poll();
            }
        }
        int[][] result = new int[idToHeap.size()][2];
        int resultTop = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : idToHeap.entrySet()) {
            result[resultTop][0] = entry.getKey();
            int sum = 0;
            for (int s : entry.getValue()) {
                sum += s;
            }
            result[resultTop][1] = sum / 5;
            ++resultTop;
        }
        Arrays.sort(result,Comparator.comparingInt(o -> o[0]));
        return result;
    }
}
