package Algorithm.DoublePointers;

public class Problem0141 {
    public boolean hasCycle(ListNode head) {
        // 相当于追击问题
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pSlow = head;
        ListNode pFast = head.next;
        while (pSlow != pFast) {
            if (pFast == null || pFast.next == null) {
                return false;
            }
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return true;
    }
}
