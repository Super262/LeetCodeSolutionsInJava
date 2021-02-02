package Others;

import java.util.ArrayList;
import java.util.Stack;

public class Problem1019 {

    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        Stack<Integer> nodeIndexStack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            while (!nodeStack.empty() && nodeStack.peek().val < current.val) {
                nodeStack.pop();
                result.set(nodeIndexStack.peek(),current.val);
                nodeIndexStack.pop();
            }
            nodeStack.push(current);
            result.add(0);
            nodeIndexStack.push(result.size() - 1);
            current = current.next;
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

