package LeetCode.Easy;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode root, LinkedList<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
}
