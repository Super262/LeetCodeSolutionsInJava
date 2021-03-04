package DataStructure.LinkedList;

import java.util.Stack;

public class Problem0445 {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        if (l1 == null || l1.val == 0) {
            return l2;
        }
        if (l2 == null || l2.val == 0) {
            return l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode p = l1;
        while (p != null) {
            s1.push(p.val);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            s2.push(p.val);
            p = p.next;
        }
        boolean hasCarry = false;
        ListNode result = new ListNode(s1.pop() + s2.pop());
        if (result.val > 9) {
            result.val -= 10;
            hasCarry = true;
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode cur = new ListNode(s1.pop() + s2.pop());
            if (hasCarry) {
                cur.val += 1;
                hasCarry = false;
            }
            if (cur.val > 9) {
                hasCarry = true;
                cur.val -= 10;
            }
            cur.next = result;
            result = cur;
        }
        while (!s1.isEmpty()) {
            ListNode cur = new ListNode(s1.pop());
            if (hasCarry) {
                cur.val += 1;
                hasCarry = false;
            }
            if (cur.val > 9) {
                hasCarry = true;
                cur.val -= 10;
            }
            cur.next = result;
            result = cur;
        }
        while (!s2.isEmpty()) {
            ListNode cur = new ListNode(s2.pop());
            if (hasCarry) {
                cur.val += 1;
                hasCarry = false;
            }
            if (cur.val > 9) {
                hasCarry = true;
                cur.val -= 10;
            }
            cur.next = result;
            result = cur;
        }
        if (hasCarry) {
            ListNode cur = new ListNode(1);
            cur.next = result;
            result = cur;
        }
        return result;
    }
}
