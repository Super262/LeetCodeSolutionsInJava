package Solutions;

import java.util.HashMap;

public class Problem0146 {
    private static class LRUCache {
        private final HashMap<Integer, DLinkNode> data;
        private final int capacity;
        private final DLinkNode head;
        private final DLinkNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.data = new HashMap<>(this.capacity);
            this.head = new DLinkNode(-1,-1);
            this.tail = new DLinkNode(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!data.containsKey(key)) {
                return -1;
            }
            DLinkNode currentNode = removeNode(data.get(key));
            addNodeOnLeft(currentNode);
            return currentNode.value;
        }

        public void put(int key,int value) {
            DLinkNode currentNode;
            if (data.containsKey(key)) {
                currentNode = removeNode(data.get(key));
                currentNode.value = value;
            } else {
                if (data.size() == capacity) {
                    DLinkNode deadNode = popNodeOnRight();
                    if (deadNode != null) {
                        data.remove(deadNode.key);
                    }
                }
                currentNode = new DLinkNode(key,value);
                data.put(key,currentNode);
            }
            addNodeOnLeft(currentNode);
        }

        private DLinkNode removeNode(DLinkNode target) {
            if (target == null) {
                return null;
            }
            target.prev.next = target.next;
            target.next.prev = target.prev;
            target.next = null;
            target.prev = null;
            return target;
        }

        private void addNodeOnLeft(DLinkNode target) {
            if (target == null) {
                return;
            }
            target.next = head.next;
            head.next = target;
            target.prev = target.next.prev;
            target.next.prev = target;
        }

        private DLinkNode popNodeOnRight() {
            if (tail.prev == head) {
                return null;
            }
            return removeNode(tail.prev);
        }

        private static class DLinkNode {
            final int key;
            int value;
            DLinkNode prev;
            DLinkNode next;

            DLinkNode(int key,int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
