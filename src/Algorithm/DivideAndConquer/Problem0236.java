package Algorithm.DivideAndConquer;

public class Problem0236 {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
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
