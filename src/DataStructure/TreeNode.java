package DataStructure;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    private static final String NULL = "null";

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 以LeetCode格式用字符串生成二叉树
     *
     * @param tree 有效的字符串
     * @return 二叉树根节点
     */
    public static TreeNode formTree(String tree) {
        if (tree.length() == 2) {
            return null;
        }
        String substring = tree.substring(1, tree.length() - 1);
        String[] split = substring.split("[,]");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        int cursor = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (cursor < split.length) {
            TreeNode poll = queue.poll();
            if (!split[cursor].equals(NULL)) {
                TreeNode left = new TreeNode(Integer.parseInt(split[cursor]));
                Objects.requireNonNull(poll).left = left;
                queue.add(left);
            }
            cursor++;
            if (cursor < split.length && !split[cursor].equals(NULL)) {
                TreeNode right = new TreeNode(Integer.parseInt(split[cursor]));
                Objects.requireNonNull(poll).right = right;
                queue.add(right);
            }
            cursor++;
        }
        return root;
    }
}
