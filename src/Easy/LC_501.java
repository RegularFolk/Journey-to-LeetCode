package Easy;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC_501 {
    /*
     * BST的基本性质
     * */
    private int max = 0, count = 0, prev = Integer.MIN_VALUE;
    private final List<Integer> ans = new LinkedList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        return ans.stream().mapToInt(a -> a).toArray();
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (root.val != prev) count = 0;
            prev = root.val;
            count++;
            if (count == max) ans.add(root.val);
            else if (count > max) {
                max = count;
                ans.clear();
                ans.add(root.val);
            }
            inOrder(root.right);
        }
    }
}
