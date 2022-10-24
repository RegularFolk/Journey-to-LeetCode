package Leet.Easy;

import DataStructure.TreeNode;
import org.junit.Test;

import java.util.Objects;

public class LC_671 {
    /*
     * DFS
     * */
    private int min1, min2;

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) return -1;
        min1 = Math.min(root.left.val, root.right.val);
        min2 = Math.max(root.left.val, root.right.val);
        dfs(root.left);
        dfs(root.right);
        return min1 == min2 ? -1 : min2;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            if (root.val < min1) {
                min2 = min1;
                min1 = root.val;
            } else if (min2 == min1 || root.val != min1 && root.val < min2) {
                min2 = root.val;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }

    @Test
    public void c() {
        int value = findSecondMinimumValue(Objects.requireNonNull(TreeNode.formTree("[1,1,1,1,5,1,4]")));
        System.out.println(value);
    }
}
