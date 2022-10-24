package Leet.Medium;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC_971 {
    /*
     * µ›πÈ
     * */
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        LinkedList<Integer> ans = new LinkedList<>();
        int i = preOrder(root, voyage, 0, ans);
        if (i == -1) {
            ans = new LinkedList<>();
            ans.add(-1);
        }
        return ans;
    }

    /*
    * ∑µªÿ-1±Ì æ∆•≈‰ ß∞‹
    * */
    private int preOrder(TreeNode root, int[] voyage, int index, LinkedList<Integer> ans) {
        if (root == null) return index;
        if (index < voyage.length) {
            if (root.val != voyage[index]) return -1;
            if (index == voyage.length - 1) return index + 1;
            int left = preOrder(root.left, voyage, index + 1, ans);
            if (left == -1) {
                int right = preOrder(root.right, voyage, index + 1, ans);
                if (right == -1) return -1;
                ans.add(root.val);
                return preOrder(root.left, voyage, right, ans);
            }
            return preOrder(root.right, voyage, left, ans);
        }
        return index;
    }
}
