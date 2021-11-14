package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem0095 {
    private List<TreeNode> createBST(int[] values,int startIndex,int endIndex,int rootIndex) {
        if (startIndex > endIndex) {
            return new LinkedList<>();
        }
        if (rootIndex > endIndex || rootIndex < startIndex) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> result = new LinkedList<>();
        if (startIndex == endIndex) {
            result.addLast(new TreeNode(values[rootIndex]));
            return result;
        }
        LinkedList<TreeNode> leftChildren = new LinkedList<>();
        LinkedList<TreeNode> rightChildren = new LinkedList<>();
        for (int i = startIndex; i < rootIndex; ++i) {
            leftChildren.addAll(createBST(values,startIndex,rootIndex - 1,i));
        }
        for (int i = rootIndex + 1; i <= endIndex; ++i) {
            rightChildren.addAll(createBST(values,rootIndex + 1,endIndex,i));
        }
        if (!leftChildren.isEmpty() && !rightChildren.isEmpty()) {
            for (TreeNode l : leftChildren) {
                for (TreeNode r : rightChildren) {
                    TreeNode root = new TreeNode(values[rootIndex]);
                    root.left = l;
                    root.right = r;
                    result.addLast(root);
                }
            }
        } else {
            if (leftChildren.isEmpty() && rightChildren.isEmpty()) {
                TreeNode root = new TreeNode(values[rootIndex]);
                result.addLast(root);
                return result;
            } else {
                if (leftChildren.isEmpty()) {
                    for (TreeNode r : rightChildren) {
                        TreeNode root = new TreeNode(values[rootIndex]);
                        root.left = null;
                        root.right = r;
                        result.addLast(root);
                    }
                } else {
                    for (TreeNode l : leftChildren) {
                        TreeNode root = new TreeNode(values[rootIndex]);
                        root.left = l;
                        root.right = null;
                        result.addLast(root);
                    }
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        int[] values = new int[n];
        for (int i = 0; i < values.length; ++i) {
            values[i] = i + 1;
        }
        LinkedList<TreeNode> result = new LinkedList<>();
        for (int i = 0; i < values.length; ++i) {
            result.addAll(createBST(values,0,values.length - 1,i));
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
