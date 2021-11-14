package Solutions;

import java.util.*;

public class Problem0103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean isFromLeft = true;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            for (int i = queue.size(); i > 0; --i) {
                TreeNode t = queue.poll();
                tempResult.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            if (!isFromLeft) {
                Collections.reverse(tempResult);
            }
            isFromLeft = !isFromLeft;
            result.add(tempResult);
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
