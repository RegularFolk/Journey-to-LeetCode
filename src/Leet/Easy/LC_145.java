package Leet.Easy;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_145 {
    /*
     * 二叉树的后序遍历
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            dfs(root.left, list);
            dfs(root.right, list);
            list.add(root.val);
        }
    }
}
