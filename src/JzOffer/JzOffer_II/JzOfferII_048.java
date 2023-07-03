package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

public class JzOfferII_048 {

    /*
     * �����������л�,DFS or BFS,�˴�ʹ��DFS
     * �ؼ������ڼ�¼�սڵ�,���ö��ŷָ�,�սڵ���X���
     * */
    public static class Codec {
        private int cursor = 0;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            doSerialize(builder, root);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }

        private void doSerialize(StringBuilder builder, TreeNode root) {
            if (root == null) builder.append("X,");
            else {
                builder.append(root.val).append(",");
                doSerialize(builder, root.left);
                doSerialize(builder, root.right);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split("[,]");
            return doDeserialize(split);
        }

        private TreeNode doDeserialize(String[] split) {
            if (split[cursor].equals("X")) {
                cursor++;
                return null;
            }
            TreeNode treeNode = new TreeNode();
            treeNode.val = Integer.parseInt(split[cursor++]);
            treeNode.left = doDeserialize(split);
            treeNode.right = doDeserialize(split);
            return treeNode;
        }
    }
}
