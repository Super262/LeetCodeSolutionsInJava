package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Problem0021 {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Queue<ListNode> q = new LinkedList<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                q.add(p2);
                p2 = p2.next;
            } else {
                q.add(p1);
                p1 = p1.next;
            }
        }
        while (p1 != null) {
            q.add(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            q.add(p2);
            p2 = p2.next;
        }
        ListNode head = q.poll();
        ListNode newP = head;
        while (!q.isEmpty()) {
            newP.next = q.poll();
            newP = newP.next;
        }
        return head;
    }
}
