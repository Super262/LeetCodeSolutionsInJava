package Solutions;

public class Problem0160 {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null && p2 == null) {
                return null;
            }
            p1 = p1 == null ? headB : p1;
            p2 = p2 == null ? headA : p2;
        }
        return p1;
    }
}
