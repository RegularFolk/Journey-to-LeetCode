package Easy;

import DataStructure.TreeNode;

public class LC_2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
