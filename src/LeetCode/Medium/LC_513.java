package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_513 {

    int max, ans;

    public int findBottomLeftValue(TreeNode root) {  //层序遍历，思路是找到每次换层的第一个
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = root.val, currentLen = 1, nextLen = 0;
        queue.add(root);
        while (currentLen > 0 || nextLen > 0) {
            if (currentLen > 0) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                    nextLen++;
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                    nextLen++;
                }
                queue.poll();
                currentLen--;
            } else {
                currentLen = nextLen;
                nextLen = 0;
                ans = queue.peek().val;
            }
        }
        return ans;
    }

    /*
    * 带条件的dfs，当深度大于旧的深度时才会更新
    * */
    public int findBottomLeftValue1(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int i) {
        if (root != null) {
            if (i > max) {
                max = i;
                ans = root.val;
            }
            dfs(root.left, i + 1);
            dfs(root.right, i + 1);
        }
    }
}
