package Leet.Hard;

import DataStructure.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

public class LC_297 {
    /*
     * 同JzOffer_37,37是递归，这里是层序遍历
     * */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            LinkedList<TreeNode> q = new LinkedList<>();
            q.add(root);
            StringBuilder builder = new StringBuilder();
            int cur = 1, next = 0;
            while (q.size() > 0) {
                while (cur-- > 0) {
                    TreeNode first = q.removeFirst();
                    if (first.val != -2000) {//不是空节点
                        if (first.left != null || first.right != null) {//不是叶子结点
                            builder.append(first.val).append(",");
                            next += 2;
                            q.addLast(first.left == null ? new TreeNode(-2000) : first.left);
                            q.addLast(first.right == null ? new TreeNode(-2000) : first.right);
                        } else {
                            builder.append(first.val).append("y,");
                        }
                    } else {
                        builder.append("x,");
                    }
                }
                cur = next;
                next = 0;
            }
            return builder.deleteCharAt(builder.length() - 1).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) {
                return null;
            }
            String[] split = data.split("[,]");
            if (split.length == 1) {
                return new TreeNode(Integer.parseInt(split[0].substring(0, split[0].length() - 1)));
            }
            int cur = 1;
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            LinkedList<TreeNode> q = new LinkedList<>();
            q.addLast(root);
            while (cur < split.length) {
                TreeNode first = q.removeFirst();
                if (!split[cur].equals("x")) {
                    if (split[cur].contains("y")) {
                        first.left = new TreeNode(Integer.parseInt(split[cur].substring(0, split[cur].length() - 1)));
                    } else {
                        TreeNode left = new TreeNode(Integer.parseInt(split[cur]));
                        first.left = left;
                        q.addLast(left);
                    }
                }
                cur++;
                if (cur < split.length && !split[cur].equals("x")) {
                    if (split[cur].contains("y")) {
                        first.right = new TreeNode(Integer.parseInt(split[cur].substring(0, split[cur].length() - 1)));
                    } else {
                        TreeNode right = new TreeNode(Integer.parseInt(split[cur]));
                        first.right = right;
                        q.addLast(right);
                    }
                }
                cur++;
            }
            return root;
        }

        @Test
        public void s() {
            String serialize = serialize(TreeNode.formTree("[1,2,3,null,null,4,5]"));
            System.out.println(serialize);
            TreeNode node = deserialize(serialize);
            System.out.println(node);
        }
    }
}
