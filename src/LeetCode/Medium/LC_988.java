package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_988 {
    /*
     * ʵ���Ǽ򵥵Ķ�������·����
     * */
    private String ans = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode root, StringBuilder builder) {
        if (root != null) {
            StringBuilder append = new StringBuilder(String.valueOf((char) (root.val + 'a'))).append(builder);
            if (root.left == null && root.right == null) {
                if (ans.equals("") || append.toString().compareTo(ans) < 0) {
                    ans = append.toString();
                }
            } else {
                dfs(root.left, append);
                dfs(root.right, append);
            }
        }
    }
}
