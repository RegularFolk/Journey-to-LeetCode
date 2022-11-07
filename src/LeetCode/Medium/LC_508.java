package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.*;

public class LC_508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> rec = new HashMap<>();
        int maxCount = 0, count = 0;
        root.val += sum(root.left) + sum(root.right);
        maxCount = travel(root, rec, maxCount);
        Set<Map.Entry<Integer, Integer>> entries = rec.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == maxCount) {
                ans.add(entry.getKey());
                count++;
            }
        }
        int[] res = new int[count];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private int travel(TreeNode root, Map<Integer, Integer> rec, int maxCount) {
        int current = rec.getOrDefault(root.val, 0) + 1;
        maxCount = Math.max(maxCount, current);
        rec.put(root.val, current);
        if (root.left != null && root.right != null) {
            return Math.max(maxCount, Math.max(travel(root.left, rec, maxCount), travel(root.right, rec, maxCount)));
        } else if (root.left != null) {
            return Math.max(maxCount, travel(root.left, rec, maxCount));
        } else if (root.right != null) {
            return Math.max(maxCount, travel(root.right, rec, maxCount));
        }
        return maxCount;
    }

    private int sum(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                root.val = root.val + sum(root.left) + sum(root.right);
            } else if (root.left != null) {
                root.val = root.val + sum(root.left);
            } else if (root.right != null) {
                root.val = root.val + sum(root.right);
            }
            return root.val;
        } else {
            return 0;
        }
    }
}
