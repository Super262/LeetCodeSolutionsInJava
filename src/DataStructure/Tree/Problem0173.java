package DataStructure.Tree;

import java.util.LinkedList;

public class Problem0173 {
    private static class BSTIterator {
        private final LinkedList<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode curNode = stack.poll();
            if (curNode == null) {
                return -1;
            }
            TreeNode nextNode = curNode.right;
            while (nextNode != null) {
                stack.addFirst(nextNode);
                nextNode = nextNode.left;
            }
            return curNode.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
