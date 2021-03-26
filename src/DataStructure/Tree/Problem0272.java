package DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem0272 {
    public List<Integer> closestKValues(TreeNode root,double target,int k) {
        List<Integer> result = new LinkedList<>();
        if (root == null || k == 0) {
            return result;
        }
        Stack<TreeNode> lowerStack = initializeStack(root,target);
        Stack<TreeNode> upperStack = new Stack<>();
        upperStack.addAll(lowerStack);
        if ((double) lowerStack.peek().val > target) {
            moveLower(lowerStack);
        } else {
            moveUpper(upperStack);
        }
        for (int i = 0; i < k; ++i) {
            if (lowerStack.isEmpty() || (!upperStack.isEmpty() && Math.abs((double) lowerStack.peek().val - target) > Math.abs((double) upperStack.peek().val - target))) {
                result.add(upperStack.peek().val);
                moveUpper(upperStack);
            } else {
                result.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
        }
        return result;
    }

    private Stack<TreeNode> initializeStack(TreeNode root,double target) {
        Stack<TreeNode> s = new Stack<>();
        while (root != null) {
            s.push(root);
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return s;
    }

    private void moveUpper(Stack<TreeNode> s) {
        TreeNode node = s.peek();
        if (node.right == null) {
            node = s.pop();
            while (!s.isEmpty() && s.peek().right == node) {
                node = s.pop();
            }
            return; // Don't forget this!
        }
        node = node.right;
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }

    private void moveLower(Stack<TreeNode> s) {
        TreeNode node = s.peek();
        if (node.left == null) {
            node = s.pop();
            while (!s.isEmpty() && s.peek().left == node) {
                node = s.pop();
            }
            return; // Don't forget this!
        }
        node = node.left;
        while (node != null) {
            s.push(node);
            node = node.right;
        }
    }
}
