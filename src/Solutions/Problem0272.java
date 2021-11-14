package Solutions;

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
            if (isLowerCloser(lowerStack,upperStack,target)) {
                result.add(lowerStack.peek().val);
                moveLower(lowerStack);
            } else {
                result.add(upperStack.peek().val);
                moveUpper(upperStack);
            }
        }
        return result;
    }

    private boolean isLowerCloser(Stack<TreeNode> lowerStack,Stack<TreeNode> upperStack,double target) {
        if (lowerStack.isEmpty()) {
            return false;
        }
        if (upperStack.isEmpty()) {
            return true;
        }
        return Math.abs((double) lowerStack.peek().val - target) < Math.abs((double) upperStack.peek().val - target);
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
            return; // Don't forget this line!
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
            return; // Don't forget this line!
        }
        node = node.left;
        while (node != null) {
            s.push(node);
            node = node.right;
        }
    }
}
