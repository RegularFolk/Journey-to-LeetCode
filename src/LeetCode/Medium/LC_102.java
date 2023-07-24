package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LC_102 {

    //二叉树的层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        int count = 1;
        int temp;
        Queue<TreeNode> queue = new ConcurrentLinkedDeque<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (count > 0) {
            LinkedList<Integer> insert = new LinkedList<>();
            temp = 0;
            for (int i = 0; i < count; i++) {
                if (queue.element().left != null) {
                    queue.add(queue.peek().left);
                    temp++;
                }
                if (queue.element().right != null) {
                    queue.add(queue.peek().right);
                    temp++;
                }
                if (queue.peek() != null) {
                    insert.add(queue.poll().val);
                }
            }
            count = temp;
            ans.add(insert);
        }
        return ans;
    }
}

class redo_102 {
    /*
     * 二叉树的层序遍历
     * 使用两个个队列来进行
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> upperQueue = new LinkedList<>();
        LinkedList<TreeNode> lowerQueue = new LinkedList<>();
        upperQueue.add(root);
        while (!upperQueue.isEmpty()) {
            TreeNode treeNode = upperQueue.removeFirst();
            temp.add(treeNode.val);
            if (treeNode.left != null) {
                lowerQueue.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                lowerQueue.addLast(treeNode.right);
            }
            if (upperQueue.isEmpty()) {
                ans.add(temp);
                temp = new ArrayList<>();
                upperQueue = lowerQueue;
                lowerQueue = new LinkedList<>();
            }
        }
        return ans;
    }
}
