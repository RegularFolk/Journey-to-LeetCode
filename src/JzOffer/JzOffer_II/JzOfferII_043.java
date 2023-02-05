package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

import java.util.LinkedList;

public class JzOfferII_043 {
    /*
     * BFS
     * 维护倒数两层的节点
     * */
    static class CBTInserter {

        private LinkedList<TreeNode> addLayer = new LinkedList<>();//最后一层完整的节点
        private LinkedList<TreeNode> deepestLayer = new LinkedList<>();//最后一层，新来节点加入的层
        private final TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            boolean found = false;
            addLayer.addLast(root);
            while (!found) {
                while (!addLayer.isEmpty()) {
                    TreeNode layerFirst = addLayer.getFirst();
                    if (layerFirst.left != null && layerFirst.right != null) {
                        deepestLayer.addLast(layerFirst.left);
                        deepestLayer.addLast(layerFirst.right);
                        addLayer.removeFirst();
                    } else {
                        found = true;
                        if (layerFirst.left != null) deepestLayer.addLast(layerFirst.left);
                        break;
                    }
                }
                if (!found) {
                    addLayer = deepestLayer;
                    deepestLayer = new LinkedList<>();
                }
            }
        }

        public int insert(int v) {
            TreeNode addLayerFirst = addLayer.getFirst();
            TreeNode treeNode = new TreeNode(v);
            if (addLayerFirst.left == null) addLayerFirst.left = treeNode;
            else if (addLayerFirst.right == null) {
                addLayerFirst.right = treeNode;
                addLayer.removeFirst();
            }
            deepestLayer.addLast(treeNode);
            if (addLayer.isEmpty()) {
                addLayer = deepestLayer;
                deepestLayer = new LinkedList<>();
            }
            return addLayerFirst.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
