package Algorithm.SearchMethods.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Problem0323 {
    public int countComponents(int n,int[][] edges) {
        if (edges == null || edges.length == 0) {
            return n;
        }
        HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            neighbors.put(i,new HashSet<>());
        }
        for (int[] e : edges) {
            neighbors.get(e[0]).add(e[1]);
            neighbors.get(e[1]).add(e[0]);
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                continue;
            }
            bfs(i,neighbors,visited);
            ++count;
        }
        return count;
    }

    private void bfs(int root,HashMap<Integer, HashSet<Integer>> neighbors,boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        while (!queue.isEmpty()) {
            root = queue.poll();
            for (int n : neighbors.get(root)) {
                if (visited[n]) {
                    continue;
                }
                queue.add(n);
                visited[n] = true;
            }
        }
    }
}
