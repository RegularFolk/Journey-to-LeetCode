package Easy;

import DataStructure.TreeNode;

public class LC_530 {
    /*
     * ���ö���������������
     * ���������������
     * ά��һ��ȫ����prev
     * */
    private int ans = Integer.MAX_VALUE, prev = -1;

    public int getMinimumDifference(TreeNode root) {
        inOrderPrev(root);
        return ans;
    }

    private void inOrderPrev(TreeNode root) {
        if (root != null) {
            inOrderPrev(root.left);
            if (prev != -1) ans = Math.min(ans, root.val - prev);
            prev = root.val;
            inOrderPrev(root.right);
        }
    }
}
