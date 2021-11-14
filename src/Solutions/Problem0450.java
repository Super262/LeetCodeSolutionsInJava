package Solutions;

public class Problem0450 {
    public TreeNode deleteNode(TreeNode root,int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null && root.left == null) {
                root = null;
            } else if (root.right != null && root.left != null) {
                root.val = findMax(root.left);
                root.left = deleteNode(root.left,root.val);
            } else if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        } else if (key < root.val) {
            root.left = deleteNode(root.left,key);
        } else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.right == null) {
            return root.val;
        }
        return findMax(root.right);
    }
}
