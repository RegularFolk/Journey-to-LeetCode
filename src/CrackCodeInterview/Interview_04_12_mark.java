package CrackCodeInterview;

import DataStructure.TreeNode;
import org.junit.Test;

import java.util.HashMap;

public class Interview_04_12_mark {
    private int ans = 0;

    /*
     * 以每一个节点作为开头，判断是否存在，对于平衡二叉树，时间复杂度为nlogn，一条直线则为n^2
     * */
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        travel(root, sum);
        return ans;
    }

    private void travel(TreeNode root, int sum) {
        if (root != null) {
            startFrom(root, sum);
            travel(root.left, sum);
            travel(root.right, sum);
        }
    }

    private void startFrom(TreeNode root, int sum) {
        if (root.val == sum) {
            ans++;
        }
        if (root.left != null) {
            startFrom(root.left, sum - root.val);
        }
        if (root.right != null) {
            startFrom(root.right, sum - root.val);
        }
    }

    /*
     * 遍历过程中维护一个散列表进行时间优化 key:currentSum   value:count
     * (前缀和)
     * */
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        travelWithMap(root, sum, 0, map);
        return ans;
    }

    private void travelWithMap(TreeNode root, int tar, long prev, HashMap<Long, Integer> map) {
        if (root != null) {
            prev += root.val;
            long need = prev - tar;//??? ↓ ↓ ↓ ↓
            Integer count = map.getOrDefault(need, 0), curCount = map.getOrDefault(prev, 0);
            ans += count;
            map.put(prev, curCount + 1);
            travelWithMap(root.left, tar, prev, map);
            travelWithMap(root.right, tar, prev, map);
            map.put(prev, curCount);//回溯时要复原
        }
    }
    /*
    * 对 long need = prev - tar 的理解:
    *   每次加到一个节点，记录的都是从根至此节点的总和(prev)，
    *   所以prev - tar 代表从根至此节点总和多出了sum多少，通过map判断
    *   此前是否存在由 根 到 根至该节点之间的某一节点 的和为这个超出来的值，
    *   有则找到了若干条路径，初始化map设置key=0,value=1也是这个原因
    * */

    @Test
    public void t() {
        int i = pathSum2(TreeNode.formTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22);
        System.out.println("i = " + i);
    }

}
