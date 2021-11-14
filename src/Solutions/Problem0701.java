package Solutions;

public class Problem0701 {
    public TreeNode insertIntoBST(TreeNode root,int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode currentPosition = root;
        while (true) {
            if (currentPosition.val == val) {
                break;
            } else if (currentPosition.val > val) {
                if (currentPosition.left == null) {
                    currentPosition.left = new TreeNode(val);
                    break;
                }
                currentPosition = currentPosition.left;
            } else {
                if (currentPosition.right == null) {
                    currentPosition.right = new TreeNode(val);
                    break;
                }
                currentPosition = currentPosition.right;
            }
        }
        return root;
    }
}
