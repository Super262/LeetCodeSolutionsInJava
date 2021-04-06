package DataStructure.HashTable;

import java.util.HashMap;
import java.util.HashSet;

public class Problem1429 {
    private static class FirstUnique {
        private final DLinkedNode head;
        private final DLinkedNode tail;
        private final HashMap<Integer, DLinkedNode> valueToNode;
        private final HashSet<Integer> duplicatedValues;

        public FirstUnique(int[] nums) {
            head = new DLinkedNode(-1);
            tail = new DLinkedNode(-1);
            valueToNode = new HashMap<>();
            duplicatedValues = new HashSet<>();
            head.next = tail;
            tail.prev = head;
            for (int n : nums) {
                add(n);
            }
        }

        public int showFirstUnique() {
            return head.next.value;
        }

        public void add(int value) {
            if (duplicatedValues.contains(value)) {
                return;
            }
            if (valueToNode.containsKey(value)) {
                DLinkedNode currentNode = valueToNode.get(value);
                removeNode(currentNode);
                duplicatedValues.add(value);
                valueToNode.remove(value);
            } else {
                DLinkedNode currentNode = new DLinkedNode(value);
                pushBack(currentNode);
                valueToNode.put(value,currentNode);
            }
        }

        private void removeNode(DLinkedNode target) {
            target.prev.next = target.next;
            target.next.prev = target.prev;
            target.next = null;
            target.prev = null;
        }

        private void pushBack(DLinkedNode target) {
            target.prev = tail.prev;
            target.next = tail;
            tail.prev = target;
            target.prev.next = target;
        }

        private static class DLinkedNode {
            final int value;
            DLinkedNode next;
            DLinkedNode prev;

            DLinkedNode(int value) {
                this.value = value;
            }
        }
    }
}
