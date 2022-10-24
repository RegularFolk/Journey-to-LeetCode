package Leet.Medium;

import DataStructure.TreeNode;
import org.junit.Test;


public class LC_1372 {
    /*
     * 二叉树的路径题
     * */
    private int ans = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        zigZag(root.right, true, 1);
        zigZag(root.left, false, 1);
        return Math.max(0, ans - 1);
    }

    /*
     * true往左，false往右
     * */
    private int zigZag(TreeNode root, boolean dir, int len) {
        if (root == null) {
            ans = Math.max(ans, len);
            return len;
        }
        int left = zigZag(root.left, false, len);
        int right = zigZag(root.right, true, len);
        int l;
        if (dir) {
            l = len + left;
        } else {
            l = len + right;
        }
        ans = Math.max(ans, l);
        return l;
    }

    @Test
    public void x() {
        int i = longestZigZag(TreeNode.formTree("[1,1,1,null,1,null,null,1,1,null,1]"));
        System.out.println(i);
    }
}
