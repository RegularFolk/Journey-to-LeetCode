package JzOffer;

import DataStructure.TreeNode;

import java.util.LinkedList;

public class JzOffer_68_2 {
    //先找出到两个点的路径，再在路径里面找最后一个公共点
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> route1 = new LinkedList<>();
        LinkedList<TreeNode> route2 = new LinkedList<>();
        if (find(root, p, route1) && find(root, q, route2)) {
            return findCommon(route1, route2);
        }
        throw new RuntimeException("tan90");
    }

    private boolean find(TreeNode root, TreeNode tar, LinkedList<TreeNode> route) {
        if (root != null) {
            route.addLast(root);
            if (root.val == tar.val) {
                return true;
            } else {
                boolean left = find(root.left, tar, route);
                boolean right = find(root.right, tar, route);
                if (left || right) {
                    return true;
                } else {
                    route.removeLast();
                    return false;
                }
            }
        }
        return false;
    }

    private TreeNode findCommon(LinkedList<TreeNode> route1, LinkedList<TreeNode> route2) {
        TreeNode cursor = null;
        while (route1.size() > 0 && route2.size() > 0 && route1.getFirst().val == route2.getFirst().val) {
            cursor = route1.getFirst();
            route1.removeFirst();
            route2.removeFirst();
        }
        return cursor;
    }
}
