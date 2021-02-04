package SearchMethods.BackTracking;

import java.util.LinkedList;
import java.util.List;

public class Problem0257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root != null) {
            if (root.left != null || root.right != null) {
                StringBuilder tempValue = new StringBuilder();
                List<String> postPart = binaryTreePaths(root.left);
                postPart.addAll(binaryTreePaths(root.right));
                for (String s : postPart) {
                    tempValue.append(root.val);
                    tempValue.append("->");
                    tempValue.append(s);
                    result.add(tempValue.toString());
                    tempValue.setLength(0);
                }
            } else {
                result.add(String.valueOf(root.val));
            }
        }
        return result;
    }
}
