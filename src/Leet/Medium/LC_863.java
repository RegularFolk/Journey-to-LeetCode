package Leet.Medium;

import DataStructure.TreeNode;

import java.util.*;

public class LC_863 {
    /*
     * ������ͼ
     * �ҳ�һ���Ӹ��ڵ㵽target��·��
     * */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(target.val);
            return ans;
        }
        Stack<Map.Entry<TreeNode, Boolean>> path = new Stack<>();
        findPath(root, target, path);
        findK(target.left, 1, k, ans);
        findK(target.right, 1, k, ans);
        int d = 1;
        while (path.size() > 0) {
            Map.Entry<TreeNode, Boolean> entry = path.pop();
            if (d < k) {
                TreeNode node = entry.getValue() ? entry.getKey().right : entry.getKey().left;
                findK(node, 1, k - d, ans);
            } else if (d == k) ans.add(entry.getKey().val);
            d++;
        }
        return ans;
    }

    private void findK(TreeNode root, int dis, int total, List<Integer> ans) {
        if (root != null) {
            if (dis == total) {
                ans.add(root.val);
            } else {
                findK(root.left, dis + 1, total, ans);
                findK(root.right, dis + 1, total, ans);
            }
        }
    }

    /*
     * �ҵ�һ����root��target��·�������Ҽ�¼����·���ϵ�ÿ���ڵ�target������ĸ�����
     * */
    private boolean findPath(TreeNode root, TreeNode target, Stack<Map.Entry<TreeNode, Boolean>> path) {
        if (root != null) {
            if (root == target) return true;
            Map.Entry<TreeNode, Boolean> leftEntry = new AbstractMap.SimpleEntry<>(root, true);
            path.add(leftEntry);
            boolean left = findPath(root.left, target, path);
            if (left) return true;
            path.pop();
            Map.Entry<TreeNode, Boolean> rightEntry = new AbstractMap.SimpleEntry<>(root, false);
            path.push(rightEntry);
            boolean right = findPath(root.right, target, path);
            if (right) return true;
            else path.pop();
        }
        return false;
    }
}
