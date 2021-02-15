package DoublePointers;

public class Problem0141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowP = head;
        ListNode fastP = head;
        do {
            slowP = slowP.next;
            if (slowP == null) {
                return false;
            }
            fastP = fastP.next;
            if (fastP == null) {
                return false;
            }
            fastP = fastP.next;
            if (fastP == null) {
                return false;
            }
        } while (slowP != fastP);
        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
