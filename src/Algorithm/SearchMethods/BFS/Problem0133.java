package Algorithm.SearchMethods.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem0133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> visitedCopy = new HashMap<>();
        q.add(node);
        visitedCopy.put(node,new Node(node.val));
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (Node n : curNode.neighbors) {
                if (!visitedCopy.containsKey(n)) {
                    visitedCopy.put(n,new Node(n.val));
                    q.add(n);
                }
                visitedCopy.get(curNode).neighbors.add(visitedCopy.get(n));
            }
        }
        return visitedCopy.get(node);
    }
}
