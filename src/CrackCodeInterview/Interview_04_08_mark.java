package CrackCodeInterview;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Interview_04_08_mark {

    /*
     * 对所有节点逐一判断，是否同时包含两个节点,编码麻烦，勉强通过
     * */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return travel(root, p, q, false);
    }

    private TreeNode travel(TreeNode root, TreeNode p, TreeNode q, boolean confirm) {
        if (root == null) {
            return null;
        }
        boolean cr = confirm || check(root, p, q);
        if (cr) {
            boolean left = check(root.left, p, q);
            if (left) {
                return travel(root.left, p, q, true);
            }
            boolean right = check(root.right, p, q);
            if (right) {
                return travel(root.right, p, q, true);
            }
            return root;
        }
        return null;
    }

    /*
     * 检查一个节点是否包含两个子节点,层序遍历
     * */
    private boolean check(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1, next = 0, count = 2;
        while (cur != 0) {
            while (cur-- > 0) {
                TreeNode poll = queue.poll();
                if (poll.val == p.val || poll.val == q.val) {
                    count--;
                    if (count == 0) {
                        return true;
                    }
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                    next++;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    next++;
                }
            }
            cur = next;
            next = 0;
        }
        return false;
    }

    /*
     * 跟法一一样的思路，更好的编码，略快
     * */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        boolean pLeft = covers(root.left, p);
        boolean qLeft = covers(root.left, q);
        if (qLeft ^ pLeft) {//在不同两边
            return root;
        }
        TreeNode childSide = pLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    /*
     * 一次搜一个，搜两次
     * */
    private boolean covers(TreeNode root, TreeNode tar) {
        if (root == null) {
            return false;
        }
        if (root == tar) {
            return true;
        }
        return covers(root.left, tar) || covers(root.right, tar);
    }

    /*
    * 最优化解法，避免重复搜索
    *   包含p或者q就返回p或者q
    *   都没有就返回null
    *   都有就返回共同祖先
    * 测试用例比前两个快一百倍以上
    * */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p && root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        if (left != null && left != p && left != q) {//找到了祖先
            return left;
        }
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        if (right != null && right != p && right != q) { //找到了祖先
            return right;
        }
        if (left != null && right != null) {//都找到了，但都不是祖先，说明当前是最近祖先
            return root;
        } else if (root == p || root == q) {//都没找到，但当前是其中一个节点
            return root;
        } else {//返回非空的一个
            return left == null ? right : left;
        }
    }
}
