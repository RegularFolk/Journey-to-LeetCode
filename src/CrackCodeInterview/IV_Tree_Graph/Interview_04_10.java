package CrackCodeInterview.IV_Tree_Graph;

import DataStructure.TreeNode;

public class Interview_04_10 {
    /*
    * 实际上还是爆拽，通过根节点相同进行了一定程度的剪枝，
    * 理论上平均时间复杂度是线性复杂度
    * */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val && match(t1, t2)) {
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    private boolean match(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {//合法终点
            return true;
        } else if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return match(t1.left, t2.left) && match(t1.right, t2.right);
    }
}
