package Solutions;

public class Problem0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null) {
            p2 = p2.next;
            if (p1.val != p2.val) {
                p1.next = p2;
                p1 = p2;
            }
        }
        p1.next = null;
        return head;
    }
}
