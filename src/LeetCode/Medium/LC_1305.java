package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        travel(root1, list1);
        travel(root2, list2);
        List<Integer> ans = new ArrayList<>(list1.size() + list2.size());
        int cursor1 = 0, cursor2 = 0;
        while (cursor1 < list1.size() && cursor2 < list2.size()) {
            if (list1.get(cursor1) >= list2.get(cursor2)) {
                ans.add(list1.get(cursor1));
                cursor1++;
            } else {
                ans.add(list2.get(cursor2));
                cursor2++;
            }
        }
        if (cursor1 < list1.size()) {
            while (cursor1 < list1.size()) {
                ans.add(list1.get(cursor1));
                cursor1++;
            }
        } else {
            while (cursor2 < list2.size()) {
                ans.add(list2.get(cursor2));
                cursor2++;
            }
        }
        return ans;
    }

    private void travel(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            if (treeNode.left != null) {
                travel(treeNode.left, list);
            }
            list.add(treeNode.val);
            if (treeNode.right != null) {
                travel(treeNode.right, list);
            }
        }
    }

}
