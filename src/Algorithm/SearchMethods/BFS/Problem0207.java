package Algorithm.SearchMethods.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem0207 {
    public boolean canFinish(int numCourses,int[][] prerequisites) {
        Graph graph = new Graph(numCourses,prerequisites);
        LinkedList<Integer> order = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.inDegree.length; ++i) {
            if (graph.inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            order.add(node);
            for (int n : graph.neighbors.get(node)) {
                --graph.inDegree[n];
                if (graph.inDegree[n] == 0) {
                    queue.add(n);
                }
            }
        }
        return order.size() == numCourses;
    }

    private static class Graph {
        private final HashMap<Integer, LinkedList<Integer>> neighbors;
        private final int[] inDegree;

        Graph(int n,int[][] edges) {
            neighbors = new HashMap<>();
            inDegree = new int[n];
            for (int i = 0; i < n; ++i) {
                neighbors.put(i,new LinkedList<>());
                inDegree[i] = 0;
            }
            for (int[] e : edges) {
                neighbors.get(e[1]).add(e[0]);
                ++inDegree[e[0]];
            }
        }

        HashMap<Integer, LinkedList<Integer>> getNeighbors() {
            return neighbors;
        }

        int[] getInDegree() {
            return inDegree;
        }
    }
}
