package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LC_6182 {
    /*
     * ¶þ²æÊ÷µÄ²ãÐò±éÀú
     * */
    public TreeNode reverseOddLevels(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cur = 1;
        boolean odd = true;
        while (!q.isEmpty()) {
            int next = 0;
            ArrayList<TreeNode> arrayList = new ArrayList<>();
            while (cur-- > 0) {
                TreeNode first = q.removeFirst();
                if (first.left != null) {
                    q.addLast(first.left);
                    next++;
                }
                if (first.right != null) {
                    q.addLast(first.right);
                    next++;
                }
                if (!odd) {
                    arrayList.add(first);
                }
            }
            odd = !odd;
            cur = next;
            reverse(arrayList);
        }
        return root;
    }

    private void reverse(ArrayList<TreeNode> arrayList) {
        if (!arrayList.isEmpty()) {
            int l = 0, r = arrayList.size() - 1;
            while (l < r) {
                TreeNode left = arrayList.get(l);
                TreeNode right = arrayList.get(r);
                int val = left.val;
                left.val = right.val;
                right.val = val;
                l++;
                r--;
            }
        }
    }
}
