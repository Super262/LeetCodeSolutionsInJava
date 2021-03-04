package DataStructure.LinkedList;

public class Problem0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2;
        int t;
        while (p1 != null) {
            p2 = p1.next;
            if (p2 == null) {
                return head;
            }
            t = p1.val;
            p1.val = p2.val;
            p2.val = t;
            p1 = p2.next;
        }
        return head;
    }
}
