package JzOffer.JzOffer_I;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class JzOffer_34 {

    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) { //经典dfs
        if (root != null) {
            search(root, target, new Stack<>());
        }
        return ans;
    }

    private void search(TreeNode root, int tar, Stack<Integer> stack) {
        if (root != null) {
            stack.push(root.val);
            if (root.val == tar && root.left == null && root.right == null) {
                ans.add(new LinkedList<>(stack));
            } else {
                search(root.left, tar - root.val, stack);
                search(root.right, tar - root.val, stack);
            }
            stack.pop();
        }
    }


    public List<List<Integer>> pathSum1(TreeNode root, int target) { //看错了，以为是任意路劲且全为正数，实际上是有问题的
        travel(root, target);
        return ans;
    }

    private void travel(TreeNode root, int target) {
        if (root != null) {
            if (root.val < target) {
                List<Integer> route1 = new LinkedList<>();
                List<Integer> route2 = new LinkedList<>();
                if (find(root.left, target - root.val, route1)) {
                    route1 = reverse(route1);
                    route1.add(0, root.val);
                    ans.add(route1);
                }
                if (find(root.right, target - root.val, route2)) {
                    route2 = reverse(route2);
                    route2.add(0, root.val);
                    ans.add(route2);
                }
            } else if (root.val == target) {
                List<Integer> route = new LinkedList<>();
                route.add(target);
                ans.add(route);
            }
            travel(root.left, target);
            travel(root.right, target);
        }
    }

    private List<Integer> reverse(List<Integer> route) {
        List<Integer> rev = new LinkedList<>();
        for (int i = route.size() - 1; i >= 0; i--) {
            rev.add(route.get(i));
        }
        return rev;
    }

    private boolean find(TreeNode root, int tar, List<Integer> route) {
        if (root != null) {
            if (root.val == tar) {
                route.add(root.val);
                return true;
            } else if (find(root.left, tar - root.val, route) || find(root.right, tar - root.val, route)) {
                route.add(root.val);
                return true;
            }
        }
        return false;
    }

}
