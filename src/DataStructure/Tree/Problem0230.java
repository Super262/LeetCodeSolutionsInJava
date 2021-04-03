package DataStructure.Tree;

import java.util.Stack;

public class Problem0230 {
    public int kthSmallest(TreeNode root,int k) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
        for (int i = 0; i < k - 1; ++i) {
            currentNode = stack.peek();
            if (currentNode.right != null) {
                currentNode = currentNode.right;
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }
            } else {
                currentNode = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == currentNode) {
                    currentNode = stack.pop();
                }
            }
        }
        return stack.peek().val;
    }
}
