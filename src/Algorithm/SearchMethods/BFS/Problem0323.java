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
        Node[] graph = makeGraph(n,edges);
        HashMap<Node, Boolean> visited = new HashMap<>();
        n = 0;
        for (Node v : graph) {
            if (visited.containsKey(v) && visited.get(v)) {
                continue;
            }
            bfs(v,visited);
            ++n;
        }
        return n;
    }

    private void bfs(Node root,HashMap<Node, Boolean> visited) {
        Queue<Node> q = new LinkedList<>();
        visited.put(root,true);
        q.add(root);
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (Node n : curNode.neighbors) {
                if (visited.containsKey(n) && visited.get(n)) {
                    continue;
                }
                q.add(n);
                visited.put(n,true);
            }
        }
    }

    private Node[] makeGraph(int n,int[][] edges) {
        Node[] graph = new Node[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new Node();
        }
        for (int[] e : edges) {
            graph[e[0]].neighbors.add(graph[e[1]]);
            graph[e[1]].neighbors.add(graph[e[0]]);
        }
        return graph;
    }

    private static class Node {
        private final HashSet<Node> neighbors;

        Node() {
            this.neighbors = new HashSet<>();
        }
    }
}
