package Hard;

import DataStructure.TreeNode;

public class LC_1373 {
    /*
     * �Ե����ϵݹ�
     * */
    private int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    /*
     * int[0]��ʾ�Ƿ�ΪBST
     * int[1]��ʾ��������С�ڵ�
     * int[2]��ʾ���������ڵ�
     * int[3]��ʾ����������
     * */
    private int[] dfs(TreeNode root) {
        if (root != null) {
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            boolean bst = (left == null || (left[0] == 1 && left[2] < root.val)) && (right == null || (right[0] == 1 && right[1] > root.val));
            if (!bst) return new int[]{0};
            int sum = (left == null ? 0 : left[3]) + (right == null ? 0 : right[3]) + root.val;
            ans = Math.max(ans, sum);
            return new int[]{1, left == null ? root.val : left[1], right == null ? root.val : right[2], sum};
        }
        return null;//�������ʾ�սڵ�
    }
}
