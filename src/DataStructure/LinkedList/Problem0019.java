package DataStructure.LinkedList;

public class Problem0019 {
    public ListNode removeNthFromEnd(ListNode head,int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode prev = null;
        ListNode target = head;
        ListNode tail = head;
        while (n > 0 && tail != null) {
            tail = tail.next;
            --n;
        }
        if (n > 0) {
            return head;
        }
        while (tail != null) {
            tail = tail.next;
            prev = target;
            target = target.next;
        }
        if (prev != null) {
            prev.next = target.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
