package Solutions;

public class Problem0114 {
    public void flatten(TreeNode root) {
        flattenAndReturnLastNode(root);
    }

    private TreeNode flattenAndReturnLastNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftLastNode = flattenAndReturnLastNode(root.left);
        TreeNode rightLastNode = flattenAndReturnLastNode(root.right);
        if (leftLastNode != null) {
            leftLastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLastNode != null) {
            return rightLastNode;
        }
        if (leftLastNode != null) {
            return leftLastNode;
        }
        return root;
    }
}
