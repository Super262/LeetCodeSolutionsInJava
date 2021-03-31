package Algorithm.SearchMethods.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem0210 {
    public int[] findOrder(int numCourses,int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, LinkedList<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            neighbors.put(i,new LinkedList<>());
            inDegree[i] = 0;
        }
        for (int[] edge : prerequisites) {
            neighbors.get(edge[1]).add(edge[0]);
            ++inDegree[edge[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int resultTop = 0;
        int curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            result[resultTop++] = curNode;
            for (int n : neighbors.get(curNode)) {
                --inDegree[n];
                if (inDegree[n] == 0) {
                    queue.add(n);
                }
            }
        }
        if (resultTop == numCourses) {
            return result;
        }
        return new int[0];
    }
}
