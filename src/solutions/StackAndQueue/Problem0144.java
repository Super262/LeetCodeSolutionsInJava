package solutions.StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            result.add(parent.val);
            if (parent.right != null) {
                stack.add(parent.right);
            }
            if (parent.left != null) {
                stack.add(parent.left);
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
