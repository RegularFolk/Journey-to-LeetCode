package Medium;

import DataStructure.TreeNode;
import org.junit.Test;

public class LC_129 {
    /*
     * DFS
     * */
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root != null) {
            sum = sum * 10 + root.val;
            if (root.left == null && root.right == null) ans += sum;
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }


    @Test
    public void x() {
        int i = Integer.parseInt("012");
        System.out.println(i);
    }
}
