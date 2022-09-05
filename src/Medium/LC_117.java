package Medium;

import DataStructure.Node;

public class LC_117 {
    /*
     * LC_116的升级版，非完全二叉树
     * 思路不同
     * 需要层层迭代,更加复杂
     * */
    public Node connect(Node root) {
        Node mark = null, cursor = root;
        while (cursor != null) {
            if (cursor.left != null || cursor.right != null) {
                if (cursor.left != null) cursor.left.next = cursor.right;
                if (mark == null) mark = cursor.left == null ? cursor.right : cursor.left;
                Node temp = cursor.next;
                while (temp != null && temp.left == null && temp.right == null) temp = temp.next;
                Node node = cursor.right == null ? cursor.left : cursor.right;
                if (temp != null) node.next = temp.left == null ? temp.right : temp.left;
            }
            if (cursor.next != null) cursor = cursor.next;
            else {
                cursor = mark;
                mark = null;
            }
        }
        return root;
    }
}
