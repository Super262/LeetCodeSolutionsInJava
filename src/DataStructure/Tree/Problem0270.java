package DataStructure.Tree;

public class Problem0270 {
    public int closestValue(TreeNode root,double target) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        TreeNode upper = root;
        TreeNode lower = root;
        while (root != null) {
            if (root.val > target) {
                upper = root;
                root = root.left;
            } else if (root.val < target) {
                lower = root;
                root = root.right;
            } else {
                return root.val;
            }
        }
        // 注意 upper.val 不一定比 target 大；lower.val 不一定比 target 小
        if (Math.abs(upper.val - target) < Math.abs(lower.val - target)) {
            return upper.val;
        } else {
            return lower.val;
        }
    }
}
