package JzOffer.JzOffer_I;

import DataStructure.TreeNode;
import org.junit.Test;

public class JzOffer_37 {

    @Test
    public void te() {
        System.out.println("Integer.valueOf(\"-10\") = " + Integer.valueOf("-10"));
        System.out.println("serialize(new TreeNode(1,new TreeNode(2),new TreeNode(3,new TreeNode(4),new TreeNode(5)))) = " +
                serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))));
        System.out.println("Integer.parseInt(\"-10\") = " + Integer.parseInt("-10"));
        System.out.println("deserialize(\"1,2y,3,4y,5y,\") = " + deserialize("1,2y,3,4y,5y,"));
    }

    private int count = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder string = new StringBuilder();
        se(root, string);
        return string.toString();
    }

    private void se(TreeNode root, StringBuilder string) {
        if (root == null) {  //空节点用x代表
            string.append("x,");
        } else {
            if (isLeaf(root)) { //叶子节点后面加y
                string.append(root.val).append("y,");
            } else {
                string.append(root.val).append(',');
                se(root.left, string);
                se(root.right, string);
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        count = 0;
        String[] split = data.split("[,]");
        return des(split);
    }

    private TreeNode des(String[] split) {
        if (count < split.length) {
            TreeNode treeNode;
            String s = split[count];
            count++;
            if (isNu(s)) {
                return null;
            } else if (isLeaf(s)) {
                s = s.substring(0, s.length() - 1);
                treeNode = new TreeNode(Integer.parseInt(s));
                return treeNode;
            } else {
                treeNode = new TreeNode(Integer.parseInt(s));
                treeNode.left = des(split);
                treeNode.right = des(split);
                return treeNode;
            }
        }
        return null;
    }

    public boolean isLeaf(String string) {
        return string.charAt(string.length() - 1) == 'y';
    }

    public boolean isNu(String string) {
        return string.equals("x");
    }

    public boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }

}
