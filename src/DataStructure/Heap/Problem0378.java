package DataStructure.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem0378 {
    public int kthSmallest(int[][] matrix,int k) {
        if (matrix == null || k <= 0) {
            return Integer.MAX_VALUE;
        }
        int h = matrix.length;
        if (h == 0) {
            return Integer.MAX_VALUE;
        }
        int w = matrix[0].length;
        if (w == 0) {
            return Integer.MAX_VALUE;
        }
        boolean[][] used = new boolean[h][w];
        PriorityQueue<Node> pq = new PriorityQueue<>(k,Comparator.comparingInt(o -> o.value));
        pq.add(new Node(matrix[0][0],0,0));
        used[0][0] = true;
        Node currentNode;
        for (int i = 0; i < k - 1; ++i) {
            currentNode = pq.poll();
            if (currentNode.x + 1 < w && !used[currentNode.y][currentNode.x + 1]) {
                pq.add(new Node(matrix[currentNode.y][currentNode.x + 1],currentNode.y,currentNode.x + 1));
                used[currentNode.y][currentNode.x + 1] = true;
            }
            if (currentNode.y + 1 < w && !used[currentNode.y + 1][currentNode.x]) {
                pq.add(new Node(matrix[currentNode.y + 1][currentNode.x],currentNode.y + 1,currentNode.x));
                used[currentNode.y + 1][currentNode.x] = true;
            }
        }
        return pq.peek().value;
    }

    private static class Node {
        private final int value;
        private final int x;
        private final int y;

        private Node(int value,int y,int x) {
            this.value = value;
            this.y = y;
            this.x = x;

        }
    }
}
