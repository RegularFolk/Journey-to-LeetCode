package Medium;

import DataStructure.TreeNode;

import java.util.Stack;

public class LC_1026 {
    /*
     * ά��һ��·���ϵ��ýڵ�֮ǰ�����ֵ����Сֵ
     * ά����������ջ��¼·�ϵ������Сֵ�ı仯
     * */
    private int ans = Integer.MIN_VALUE;
    private final Stack<Integer> bigStack = new Stack<>();
    private final Stack<Integer> smallStack = new Stack<>();

    public int maxAncestorDiff1(TreeNode root) {
        dfs1(root);
        return ans;
    }

    private void dfs1(TreeNode root) {
        if (root != null) {
            int diff1 = Integer.MIN_VALUE, diff2 = Integer.MIN_VALUE;
            if (!bigStack.isEmpty()) diff1 = Math.abs(root.val - bigStack.peek());
            if (!smallStack.isEmpty()) diff2 = Math.abs(root.val - smallStack.peek());
            ans = Math.max(Math.max(diff1, diff2), ans);
            if (bigStack.isEmpty() || bigStack.peek() <= root.val) bigStack.push(root.val);
            if (smallStack.isEmpty() || smallStack.peek() >= root.val) smallStack.push(root.val);
            dfs1(root.left);
            dfs1(root.right);
            if (!bigStack.isEmpty() && bigStack.peek() == root.val) bigStack.pop();
            if (!smallStack.isEmpty() && smallStack.peek() == root.val) smallStack.pop();
        }
    }

    /*
    * ά�����ֵ�ͺã�û���õ�����
    * */
    public int maxAncestorDiff2(TreeNode root) {
        dfs2(root, root.val, root.val);
        return ans;
    }

    private void dfs2(TreeNode root, int min, int max) {
        if (root != null) {
            ans = Math.max(Math.max(Math.abs(root.val - min), Math.abs(root.val - max)), ans);
            min = Math.min(min, root.val);
            max = Math.max(max, root.val);
            dfs2(root.left, min, max);
            dfs2(root.right, min, max);
        }
    }
}
