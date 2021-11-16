package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root,path,result);
        return result;
    }

    void dfs(final TreeNode root,List<Integer> path,List<String> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder temp = new StringBuilder(String.valueOf(path.get(0)));
            for (int i = 1; i < path.size(); ++i) {
                temp.append("->");
                temp.append(path.get(i));
            }
            result.add(temp.toString());
            path.remove(path.size() - 1);
            return;
        }
        dfs(root.left,path,result);
        dfs(root.right,path,result);
        path.remove(path.size() - 1);
    }
}
