package DoublePointers;

public class Problem0141 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            } else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        return false;
    }
}
