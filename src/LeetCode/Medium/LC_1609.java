package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1609 {

    public boolean isEvenOddTree(TreeNode root) {
        boolean odd = false;
        int in = 0;
        int out = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int compare = queue.peek().val + (odd ? 1 : -1);
            for (int i = 0; i < out; i++) {
                TreeNode temp = queue.peek();
                int compareResult = compare - temp.val;
                if ((odd && (compareResult <= 0 || temp.val % 2 != 0)) || (!odd && (compareResult >= 0 || temp.val % 2 != 1))) {
                    return false;
                } else {
                    compare = temp.val;
                    if (temp.left != null) {
                        queue.add(temp.left);
                        in++;
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                        in++;
                    }
                    queue.remove();
                }
            }
            out = in;
            in = 0;
            odd = !odd;
        }
        return true;
    }
}
