package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_449 {

    //采用中序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        travel(root, ans);
        return ans.toString();
    }

    private void travel(TreeNode root, StringBuilder ans) {
        if (root != null) {
            ans.append(root.val);
            if (root.left != null) {
                ans.append(',');
                travel(root.left, ans);
            }
            if (root.right != null) {
                ans.append(",");
                travel(root.right, ans);
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        TreeNode ans = null;
        String[] split = data.split("[,]");
        for (String s : split) {
            ans = add(s, ans);
        }
        return ans;
    }

    private TreeNode add(String data, TreeNode root) {
        int value = Integer.parseInt(data);
        if (root == null) {
            return new TreeNode(value);
        } else if (value > root.val) {
            root.right = add(data, root.right);
            return root;
        } else if (value < root.val) {
            root.left = add(data, root.left);
            return root;
        } else {
            return root;
        }
    }
}
