package Medium;

import DataStructure.TreeNode;

public class LC_450 {
    //将待删除节点替换成左子树的最大值或者右子树的最小值,此处选择右子树的最小值
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                findMin(root.right).left = root.left;
                return root.right;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root.left != null) {
            return findMin(root.left);
        } else {
            return root;
        }
    }

    //法二，最初构想:将待删除节点的值替换成左右子节点中的一个，再删除左右子节点，由于java不能主动释放内存，所以当待删除节点是叶子结点的时候会比较麻烦
    //实际上这个思路是不完善的，必须针对左子树的最大值或者右子树的最小值，否则BST局部会从出错，例如待删除节点替换成的左子树有两个子节点时。
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root==null||(root.left == null && root.right == null && root.val == key)) {
            return null;
        }
        TreeNode cur = root, father = new TreeNode(0);
        boolean left = true;
        while (cur != null && cur.val != key) {
            int val = cur.val;
            father = cur;
            if (val > key) {
                left = true;
                cur = cur.left;
            } else {
                left = false;
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        } else if (cur.left != null || cur.right != null) {
            delete(cur);//至少有一个子树
        } else { //目标节点是一个叶子
            if (left) {
                father.left = null;
            } else {
                father.right = null;
            }
        }
        return root;
    }

    private void delete(TreeNode cur) {
        if (cur.left != null) {
            cur.val = cur.left.val;
            if (cur.left.left != null || cur.left.right != null) {
                delete(cur.left);
            } else {
                cur.left = null;
            }
        } else {
            cur.val = cur.right.val;
            if (cur.right.left != null || cur.right.right != null) {
                delete(cur.right);
            } else {
                cur.right = null;
            }
        }
    }
}
