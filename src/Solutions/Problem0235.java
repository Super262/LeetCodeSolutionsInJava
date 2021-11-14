package Solutions;

public class Problem0235 {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        return lowestCommonAncestor(root.right,p,q);
    }
}
