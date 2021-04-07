package DataStructure.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> candidatesPool = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode currentNode;
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            candidatesPool.add(list);
        }
        ListNode resultHead = new ListNode(-1);
        ListNode resultTop = resultHead;
        while (!candidatesPool.isEmpty()) {
            currentNode = candidatesPool.poll();
            resultTop.next = currentNode;
            if (currentNode.next != null) {
                candidatesPool.add(currentNode.next);
            }
            currentNode.next = null;
            resultTop = resultTop.next;
        }
        return resultHead.next;
    }
}
