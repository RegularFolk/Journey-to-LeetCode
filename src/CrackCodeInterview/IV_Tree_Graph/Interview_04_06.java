package CrackCodeInterview.IV_Tree_Graph;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Interview_04_06 {

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {  //法一，利用递归，找到第一个大于p的节点，再进行核对
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor1(root.right, p);
        TreeNode ans = inorderSuccessor1(root.left, p);
        return ans == null ? root : ans;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {  //法二，将二叉搜索树展开
        List<TreeNode> list = new ArrayList<>();
        travel(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val == p.val) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    void travel(TreeNode treeNode, List<TreeNode> list) {
        if (treeNode != null) {
            if (treeNode.left != null) {
                travel(treeNode.left, list);
            }
            list.add(treeNode);
            if (treeNode.right != null) {
                travel(treeNode.right, list);
            }
        }
    }
}
