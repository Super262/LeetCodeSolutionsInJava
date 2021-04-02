package Algorithm.DivideAndConquer;

import java.util.ArrayList;

public class Problem1644 {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        ArrayList<TreeNode> pPath = new ArrayList<>();
        ArrayList<TreeNode> qPath = new ArrayList<>();
        getPath(root,p,pPath);
        if (pPath.isEmpty()) {
            return null;
        }
        getPath(root,q,qPath);
        if (qPath.isEmpty()) {
            return null;
        }
        int i = 0;
        while (i < pPath.size() && i < qPath.size()) {
            if (pPath.get(i) != qPath.get(i)) {
                break;
            }
            ++i;
        }
        return pPath.get(i - 1);
    }

    private boolean getPath(TreeNode root,TreeNode target,ArrayList<TreeNode> path) {
        if (root == null || target == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        if (getPath(root.left,target,path)) {
            return true;
        }
        if (getPath(root.right,target,path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
