package DataStructure.LinkedList;

public class Problem0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;
        while (nextNode != null) {
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.next;
        }
        currentNode.next = prevNode;
        return currentNode;
    }
}
