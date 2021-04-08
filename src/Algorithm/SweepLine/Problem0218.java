package Algorithm.SweepLine;

import java.util.*;

public class Problem0218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Point[] points = new Point[buildings.length * 2];
        for (int i = 0; i < buildings.length; ++i) {
            points[i] = new Point(buildings[i][0],false,buildings[i][2],i);
            points[i + buildings.length] = new Point(buildings[i][1],true,buildings[i][2],i);
        }
        MaxHeap maxHeap = new MaxHeap();
        Arrays.sort(points,(p1,p2) -> {
            if (!p1.x.equals(p2.x)) {
                return p1.x - p2.x;
            }
            if (p1.isEnd != p2.isEnd) {
                return !p1.isEnd ? -1 : 1;
            }
            if (!p1.height.equals(p2.height)) {
                return p1.height - p2.height;
            }
            return p1.id - p2.id;
        });
        List<List<Integer>> outline = new ArrayList<>();
        for (Point p : points) {
            if (p.isEnd) {
                maxHeap.remove(p.id);
            } else {
                maxHeap.push(p);
            }
            int currentMaxH = maxHeap.peek() == null ? 0 : Objects.requireNonNull(maxHeap.peek()).height;
            if (outline.isEmpty()) {
                LinkedList<Integer> node = new LinkedList<>();
                node.addLast(p.x);
                node.addLast(currentMaxH);
                outline.add(node);
            } else if (outline.get(outline.size() - 1).get(0).equals(p.x)) {
                List<Integer> node = outline.get(outline.size() - 1);
                node.set(1,Math.max(currentMaxH,node.get(1)));
            } else if (!outline.get(outline.size() - 1).get(1).equals(currentMaxH)) {
                LinkedList<Integer> node = new LinkedList<>();
                node.addLast(p.x);
                node.addLast(currentMaxH);
                outline.add(node);
            }
        }
        return outline;
    }

    private static class MaxHeap {
        final PriorityQueue<Point> pq;
        final HashSet<Integer> removedIds;

        MaxHeap() {
            removedIds = new HashSet<>();
            pq = new PriorityQueue<>((p1,p2) -> Integer.compare(p2.height,p1.height));
        }

        void push(Point p) {
            if (p == null) {
                return;
            }
            pq.offer(p);
        }

        Point peek() {
            if (pq.isEmpty()) {
                return null;
            }
            return pq.peek();
        }

        void remove(int id) {
            removedIds.add(id);
            prune();
        }

        void prune() {
            while (!pq.isEmpty() && removedIds.contains(pq.peek().id)) {
                pq.poll();
            }
        }
    }

    private static class Point {
        final Integer x;
        final boolean isEnd;
        final Integer height;
        final Integer id;

        Point(int x,boolean isEnd,int height,int id) {
            this.x = x;
            this.isEnd = isEnd;
            this.height = height;
            this.id = id;
        }
    }

}
