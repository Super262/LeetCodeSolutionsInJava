package Solutions;

import java.util.ArrayList;

public class Problem0297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); ++i) {
            if (queue.get(i) != null) {
                queue.add(queue.get(i).left);
                queue.add(queue.get(i).right);
            }
        }
        while (!queue.isEmpty() && queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuilder result = new StringBuilder(queue.size() * 2 - 1);
        for (int i = 0; i < queue.size() - 1; ++i) {
            if (queue.get(i) != null) {
                result.append(queue.get(i).val);
            } else {
                result.append('#');
            }
            result.append(',');
        }
        result.append(queue.get(queue.size() - 1).val);
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodeValues = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        ArrayList<TreeNode> queue = new ArrayList<>(nodeValues.length);
        queue.add(root);
        int currentRootIndex = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < nodeValues.length; ++i) {
            if (!"#".equals(nodeValues[i])) {
                TreeNode child = new TreeNode(Integer.parseInt(nodeValues[i]));
                if (isLeftChild) {
                    queue.get(currentRootIndex).left = child;
                } else {
                    queue.get(currentRootIndex).right = child;
                }
                queue.add(child);
            }
            if (!isLeftChild) {
                ++currentRootIndex;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
