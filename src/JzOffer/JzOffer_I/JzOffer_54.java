package JzOffer.JzOffer_I;

import DataStructure.TreeNode;

public class JzOffer_54 {

    private int count;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        return travel(root);
    }

    public int travel(TreeNode root) {
        int ans = 0;
        if (root.right != null) {
            ans = kthLargest(root.right, count);
        }
        if (ans == 0) {
            if (count == 1) {
                ans = root.val;
            }
            count--;
        }
        if (ans == 0 && root.left != null) {
            ans = kthLargest(root.left, count);
        }
        return ans;
    }
}
