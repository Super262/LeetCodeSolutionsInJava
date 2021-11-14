package Solutions;

import java.util.HashMap;

public class Problem0138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Node currentNode = head;
        Node prevNode = null;
        while (currentNode != null) {
            Node currentCopied = new Node(currentNode.val);
            oldToNew.put(currentNode,currentCopied);
            if (prevNode != null) {
                prevNode.next = currentCopied;
            }
            prevNode = currentCopied;
            currentNode = currentNode.next;
        }
        currentNode = head;
        while (currentNode != null) {
            if (currentNode.random != null) {
                oldToNew.get(currentNode).random = oldToNew.get(currentNode.random);
            }
            currentNode = currentNode.next;
        }
        return oldToNew.getOrDefault(head,null);
    }
}
