package Solutions;

public class Problem0876 {
    public ListNode middleNode(ListNode head) {
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }
        return pSlow;
    }
}
