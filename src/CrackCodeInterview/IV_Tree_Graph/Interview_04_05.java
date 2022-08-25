package CrackCodeInterview.IV_Tree_Graph;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Interview_04_05 {

    public boolean isValidBST1(TreeNode root) {//中序展开
        if (root == null) {
            return true;
        }
        List<Integer> list = new LinkedList<>();
        spared(root, list);
        long mark = (long) Integer.MIN_VALUE - 1;
        for (Integer integer : list) {
            if ((long) integer <= mark) {
                return false;
            } else {
                mark = integer;
            }
        }
        return true;
    }

    private void spared(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            spared(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            spared(root.right, list);
        }
    }

    public boolean isValidBST2(TreeNode root) { //利用递归，维护一个最大值和最小值
        return judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean judge(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left, right = root.right;
        if (left != null && (left.val >= root.val || left.val <= minValue)) {
            return false;
        }
        if (right != null && (right.val <= root.val || right.val >= maxValue)) {
            return false;
        }
        return judge(left, minValue, root.val) && judge(right, root.val, maxValue);
    }

}
