package Easy;

import DataStructure.TreeNode;

public class LC_965 {
    public boolean isUnivalTree(TreeNode root) {
        int tar = root.val;
        return travel(root, tar);
    }

    boolean travel(TreeNode treeNode, int tar) {
        if (treeNode.val != tar) {
            return false;
        } else {
            if (treeNode.left != null) {
                if (!travel(treeNode.left, tar)) {
                    return false;
                }
            }
            if (treeNode.right != null) {
                return travel(treeNode.right, tar);
            }
            return true;
        }
    }
}
