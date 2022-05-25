package Easy;

public class LC_965 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
