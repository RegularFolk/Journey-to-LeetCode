package Medium;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Queue;

public class LC_1161 {
    public static void main(String[] args) {

    }

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

    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int max = root.val;
        int sum;
        int count = 0;
        int sonCount;
        int level = 1;
        int levelCount = 1;
        if (root.left != null) {
            count++;
            queue.add(root.left);
        }
        if (root.right != null) {
            count++;
            queue.add(root.right);
        }
        while (count > 0 && !queue.isEmpty()) {
            sum = 0;
            sonCount = 0;
            levelCount++;
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                    sonCount++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    sonCount++;
                }
                sum += temp.val;
            }
            if (sum > max) {
                max = sum;
                level = levelCount;
            }
            count = sonCount;
        }
        return level;
    }
}
