package DataStructure.UnionFind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem0305 {
    public List<Integer> numIslands2(final int m,final int n,int[][] positions) {
        int[] father = new int[m * n];
        int[] matrix = new int[m * n];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        List<Integer> result = new ArrayList<>(positions.length);
        int temp;
        int nextY;
        int nextX;
        int rootA;
        int rootB;
        for (int[] p : positions) {
            if (matrix[pointToInt(p[0],p[1],n)] == 1) {
                result.add(result.get(result.size() - 1));
                continue;
            }
            matrix[pointToInt(p[0],p[1],n)] = 1;
            father[pointToInt(p[0],p[1],n)] = pointToInt(p[0],p[1],n);
            temp = 1;
            if (result.size() > 0) {
                temp += result.get(result.size() - 1);
            }
            for (int[] d : directions) {
                nextY = d[0] + p[0];
                nextX = d[1] + p[1];
                if (nextY >= 0 && nextY < m && nextX >= 0 && nextX < n && matrix[pointToInt(nextY,nextX,n)] == 1) {
                    rootA = findAndCompress(father,pointToInt(p[0],p[1],n));
                    rootB = findAndCompress(father,pointToInt(nextY,nextX,n));
                    if (rootA != rootB) {
                        connect(father,rootA,rootB);
                        --temp;
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }

    private void connect(int[] father,int aIndex,int bIndex) {
        father[bIndex] = aIndex;
        findAndCompress(father,aIndex);
        findAndCompress(father,bIndex);
    }

    private int findAndCompress(int[] father,int nodeIndex) {
        LinkedList<Integer> path = new LinkedList<>();
        while (father[nodeIndex] != nodeIndex) {
            path.addLast(nodeIndex);
            nodeIndex = father[nodeIndex];
        }
        for (Integer p : path) {
            father[p] = nodeIndex;
        }
        return nodeIndex;
    }

    private int pointToInt(int y,int x,int n) {
        return y * n + x;
    }
}
