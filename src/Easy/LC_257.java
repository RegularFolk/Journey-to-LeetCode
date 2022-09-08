package Easy;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC_257 {
    /*
     * ¶þ²æÊ÷DFS
     * */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        dfs(root, list, new StringBuilder());
        return list;
    }

    private void dfs(TreeNode root, List<String> list, StringBuilder builder) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(builder.append(root.val).toString());
            } else {
                dfs(root.left, list, new StringBuilder(builder).append(root.val).append("->"));
                dfs(root.right, list, new StringBuilder(builder).append(root.val).append("->"));
            }
        }
    }
}
