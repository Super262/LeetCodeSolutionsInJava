package Solutions;

public class Problem0236 {
    // p and q will exist in the tree.
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p == q) {
            return p;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left,p,q);
        TreeNode rightResult = lowestCommonAncestor(root.right,p,q);
        if (leftResult != null && rightResult != null) {
            return root;
        }
        if (leftResult != null) {
            return leftResult;
        }
        return rightResult;
    }
}
