package Easy;

import DataStructure.TreeNode;

import java.util.Objects;

public class LC_1022 {

    public int sumRootToLeaf(TreeNode root) {
        return travel(root, 0);
    }

    private int travel(TreeNode root, int i) {
        i = (i << 1) + root.val;
        if (root.left == null && root.right == null) {
            return i;
        } else {
            if (root.left != null && root.right != null) {
                return travel(root.left, i) + travel(root.right, i);
            } else return travel(Objects.requireNonNullElseGet(root.left, () -> root.right), i);
        }
    }
}
