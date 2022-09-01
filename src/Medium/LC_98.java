package Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_98 {

    public boolean isValidBST(TreeNode root) {
        if (root.left != null && root.right != null) { //左右都不空
            return root.left.val < root.val && root.right.val > root.val && isValidBST(root.left) && isValidBST(root.right);
        } else if (root.left == null && root.right != null) { //左空右不空
            return root.right.val > root.val && isValidBST(root.right);
        } else if (root.left != null) {  //右空左不空
            return root.left.val < root.val && isValidBST(root.left);
        } else {  //左右全空
            return true;
        }
    }

    public boolean isValidBST1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        travel(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void travel(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            travel(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            travel(root.right, list);
        }
    }
}
