package Algorithm.SearchMethods.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem0444 {
    public boolean sequenceReconstruction(int[] org,List<List<Integer>> seqs) {
        // 有效的拓扑排序：结果长度等于节点个数
        if ((org == null || org.length == 0) && (seqs == null || seqs.size() == 0 || seqs.get(0).size() == 0)) {
            return true;
        }
        if (org == null || org.length == 0) {
            return false;
        }
        if (seqs == null || seqs.size() == 0 || seqs.get(0).size() == 0) {
            return false;
        }
        // build the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> neighbors = new HashMap<>();
        for (List<Integer> e : seqs) {
            for (Integer v : e) {
                inDegree.put(v,0);
                neighbors.put(v,new LinkedList<>());
            }
        }
        int curIndex;
        Integer prevV;
        for (List<Integer> e : seqs) {
            curIndex = 0;
            prevV = e.get(0);
            for (Integer v : e) {
                if (curIndex != 0) {
                    inDegree.put(v,inDegree.get(v) + 1);
                    neighbors.get(prevV).add(v);
                }
                prevV = v;
                ++curIndex;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer v : inDegree.keySet()) {
            if (inDegree.get(v) == 0) {
                queue.add(v);
            }
        }
        LinkedList<Integer> order = new LinkedList<>();
        Integer node;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            node = queue.poll();
            order.add(node);
            for (Integer n : neighbors.get(node)) {
                inDegree.put(n,inDegree.get(n) - 1);
                if (inDegree.get(n) == 0) {
                    queue.add(n);
                }
            }
        }
        if (order.size() != inDegree.keySet().size() || order.size() != org.length) {
            return false;
        }
        int orgTop = 0;
        for (Integer v : order) {
            if (v != org[orgTop]) {
                return false;
            }
            ++orgTop;
        }
        return true;
    }
}
