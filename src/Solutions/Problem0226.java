package Solutions;

public class Problem0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode invertedLeft = invertTree(root.left);
        TreeNode invertedRight = invertTree(root.right);
        root.right = invertedLeft;
        root.left = invertedRight;
        return root;
    }
}
