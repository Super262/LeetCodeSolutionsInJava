package DataStructure.LinkedList;

public class Problem0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int listLen = 0;
        ListNode p1 = head;
        while (p1 != null) {
            ++listLen;
            p1 = p1.next;
        }
        int mid = listLen / 2;
        ListNode p0 = null;
        p1 = head;
        ListNode p2 = head.next;
        for (int i = 0; i < mid; ++i) {
            p1.next = p0;
            p0 = p1;
            p1 = p2;
            p2 = p2.next;
        }
        if (listLen % 2 == 1) {
            p1 = p1.next;
        }
        while (p0 != null && p1 != null) {
            if (p0.val == p1.val) {
                p0 = p0.next;
                p1 = p1.next;
            } else {
                break;
            }
        }
        return p0 == null && p1 == null;
    }
}

// 1 2 2 4 2 2 1