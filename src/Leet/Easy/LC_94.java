package Leet.Easy;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;
        List<Integer> ans = new LinkedList<>();
        while (cursor != null || !stack.empty()) {
            while (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }
            if (!stack.empty()) {
                cursor = stack.pop();
                ans.add(cursor.val);
                cursor = cursor.right;
            }
        }
        return ans;
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        recursive(root, ans);
        return ans;
    }

    public static void recursive(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            recursive(treeNode.left, list);
            list.add(treeNode.val);
            recursive(treeNode.right, list);
        }
    }
}
