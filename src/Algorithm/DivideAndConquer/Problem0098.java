package Algorithm.DivideAndConquer;

public class Problem0098 {
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root,long lowerBound,long upperBound) {
        // 根据题目输入，注意边界值的选取：-2^31 <= Node.val <= 2^31 - 1
        if (root == null) {
            return true;
        }
        if (root.val >= upperBound || root.val <= lowerBound) {
            return false;
        }
        return helper(root.left,lowerBound,root.val) && helper(root.right,root.val,upperBound);
    }
}
