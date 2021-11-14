package Solutions;

import java.util.LinkedList;

public class Problem0173 {
    private static class BSTIterator {
        private final LinkedList<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            findMostLeft(root);
        }

        public int next() {
            TreeNode curNode = stack.poll();
            if (curNode == null) {
                return -1;
            }
            findMostLeft(curNode.right);
            return curNode.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void findMostLeft(TreeNode root) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
        }
    }
}
