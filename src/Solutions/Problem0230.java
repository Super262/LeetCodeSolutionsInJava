package Solutions;

public class Problem0230 {
    private int answer = -1;
    private int K;

    public int kthSmallest(TreeNode root,int k) {
        K = k;
        dfs(root);
        return answer;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (dfs(root.left)) {
            return true;
        }
        --K;
        if (K == 0) {
            answer = root.val;
            return true;
        }
        return dfs(root.right);
    }
}
