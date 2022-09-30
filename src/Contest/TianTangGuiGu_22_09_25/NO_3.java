package Contest.TianTangGuiGu_22_09_25;

import DataStructure.TreeNode;
import org.junit.Test;
import utils.ArrayUtil;

import java.util.*;

public class NO_3 {
    /*
     * ��һ�Ŷ��������ҳ�����һ��������
     * ����ɢ�б�������
     * ��ʱ
     * */
    public List<TreeNode> lightDistribution(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<Integer, ArrayList<TreeNode>> map = new HashMap<>();
        buildMap(root.left, map);
        buildMap(root.right, map);
        Set<Map.Entry<Integer, ArrayList<TreeNode>>> entries = map.entrySet();
        for (Map.Entry<Integer, ArrayList<TreeNode>> entry : entries) {
            ArrayList<TreeNode> treeNodes = entry.getValue();
            for (int i = 0; i < treeNodes.size() - 1; i++) {
                if (treeNodes.get(i) == null) continue;
                boolean flag = false;//ȥ��
                for (int j = i + 1; j < treeNodes.size(); j++) {
                    if (tryMatch(treeNodes.get(i), treeNodes.get(j))) {
                        if (!flag) {
                            flag = true;
                            ans.add(treeNodes.get(i));
                        } else treeNodes.set(j, null);
                    }
                }
            }
        }
        return ans;
    }

    private boolean tryMatch(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) return true;
        else if (treeNode1 == null || treeNode2 == null) return false;
        return treeNode1.val == treeNode2.val &&
                tryMatch(treeNode1.left, treeNode2.left) &&
                tryMatch(treeNode1.right, treeNode2.right);
    }

    private void buildMap(TreeNode root, Map<Integer, ArrayList<TreeNode>> map) {
        if (root != null) {
            ArrayList<TreeNode> nodes = map.getOrDefault(root.val, null);
            if (nodes == null) nodes = new ArrayList<>();
            nodes.add(root);
            map.put(root.val, nodes);
            buildMap(root.left, map);
            buildMap(root.right, map);
        }
    }

    @Test
    public void x() {
        List<TreeNode> list = lightDistribution(TreeNode.formTree("[1,3,3,null,2,null,2]"));
        ArrayUtil.printList(list);
    }

}
