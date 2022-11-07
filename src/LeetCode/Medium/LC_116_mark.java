package LeetCode.Medium;

import DataStructure.Node;

public class LC_116_mark {
    /*
     * �ݹ鴦����ÿһ���ڵ�������ָ���Ҷ���
     * ͬʱ����������һ���Ѿ��ѱ��ڵ��next������ˣ�����԰��Ҷ���ָ��next�������
     * ����
     * */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
