package CrackCodeInterview.XVII_Hard;

import DataStructure.TreeNode;
import org.junit.Test;

public class Interview_17_12_mark {
    /*
     * �ݹ鴦��,���벻������
     * */
    public TreeNode convertBiNode1(TreeNode root) {
        if (root == null) return null;
        TreeNode ans = getMin(root);
        transform(root);
        return ans;
    }

    /*
     * ���ش���õ������β���
     * */
    private TreeNode transform(TreeNode self) {
        if (self != null) {
            if (self.left != null) {
                TreeNode left = transform(self.left);
                left.right = self;
                self.left = null;
            }
            if (self.right != null) {
                TreeNode right = self.right;
                self.right = getMin(self.right);
                return transform(right);
            } else {
                return self;
            }
        }
        return null;
    }

    private TreeNode getMin(TreeNode node) {
        if (node.left != null) {
            return getMin(node.left);
        }
        return node;
    }

    /*
     * ά��prevǰһ���������Ľڵ㣬��������
     * */
    public TreeNode convertBiNode2(TreeNode root) {
        TreeNode head = new TreeNode(0);
        inorder(root, head);
        return head.right;
    }

    private TreeNode inorder(TreeNode node, TreeNode prev) {
        if (node != null) {
            prev = inorder(node.left, prev);
            node.left = null;
            prev.right = node;
            prev = inorder(node.right, node);
        }
        return prev;
    }


    @Test
    public void s() {
        TreeNode treeNode = convertBiNode1(TreeNode.formTree("[4,2,5,1,3,null,6,0]"));
        System.out.println(treeNode);
    }
}
