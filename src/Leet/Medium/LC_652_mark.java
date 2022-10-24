package Leet.Medium;

import DataStructure.TreeNode;
import org.junit.Test;

import java.util.*;

public class LC_652_mark {
    /*
     * 利用散列表
     * 将树序列化后比较是否出现过
     * */
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) return " ";
        String key = root.val + "_" + dfs(root.left) + dfs(root.right);
        Integer mapValue = map.getOrDefault(key, 0);
        if (mapValue == 1) ans.add(root);
        map.put(key, mapValue + 1);
        return key;
    }

    private String se(TreeNode root) {
        if (root == null) return "x,";
        return root.val + "," + se(root.left) + se(root.right);
    }

    @Test
    public void x() {
        String se = se(TreeNode.formTree("[1,2,3,4,null,2,4,null,null,4]"));
        System.out.println(se);
    }

}
