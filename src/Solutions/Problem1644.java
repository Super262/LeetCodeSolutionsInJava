package Solutions;

public class Problem1644 {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        ResultPack lcaResult = helper(root,p,q);
        if (lcaResult.pExisted && lcaResult.qExisted) {
            return lcaResult.commonAncestor;
        }
        return null;
    }

    private ResultPack helper(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null || p == null || q == null) {
            return new ResultPack(false,false,null);
        }
        ResultPack leftResultPack = helper(root.left,p,q);
        ResultPack rightResultPack = helper(root.right,p,q);
        boolean pExisted = root == p || leftResultPack.pExisted || rightResultPack.pExisted;
        boolean qExisted = root == q || leftResultPack.qExisted || rightResultPack.qExisted;
        if (root == p || root == q) {
            return new ResultPack(pExisted,qExisted,root);
        }
        if (leftResultPack.commonAncestor != null && rightResultPack.commonAncestor != null) {
            return new ResultPack(pExisted,qExisted,root);
        }
        if (leftResultPack.commonAncestor != null) {
            return new ResultPack(pExisted,qExisted,leftResultPack.commonAncestor);
        }
        if (rightResultPack.commonAncestor != null) {
            return new ResultPack(pExisted,qExisted,rightResultPack.commonAncestor);
        }
        return new ResultPack(false,false,null);
    }

    private static class ResultPack {
        private final boolean pExisted;
        private final boolean qExisted;
        private final TreeNode commonAncestor;

        ResultPack(boolean pExisted,boolean qExisted,TreeNode commonAncestor) {
            this.pExisted = pExisted;
            this.qExisted = qExisted;
            this.commonAncestor = commonAncestor;
        }
    }
}
