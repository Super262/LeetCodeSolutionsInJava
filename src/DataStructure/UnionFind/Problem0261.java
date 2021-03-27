package DataStructure.UnionFind;

import java.util.LinkedList;

public class Problem0261 {
    public boolean validTree(int n,int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        int[] father = new int[n];
        for (int i = 0; i < father.length; ++i) {
            father[i] = i;
        }
        int connectedCount = n;
        int rootA;
        int rootB;
        for (int[] e : edges) {
            rootA = findAndCompress(father,e[0]);
            rootB = findAndCompress(father,e[1]);
            if (rootA == rootB) {
                continue;
            }
            father[rootB] = rootA;
            --connectedCount;
        }
        return connectedCount == 1;
    }

    private int findAndCompress(int[] father,int nodeIndex) {
        LinkedList<Integer> path = new LinkedList<>();
        while (father[nodeIndex] != nodeIndex) {
            path.addLast(nodeIndex);
            nodeIndex = father[nodeIndex];
        }
        for (int v : path) {
            father[v] = nodeIndex;
        }
        return nodeIndex;
    }
}
