package JzOffer;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class JzOffer_32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) { //变种的层序遍历，使用两个栈
        if (root == null) {
            return new LinkedList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        boolean flag = true;
        stack1.push(root);
        List<List<Integer>> ans = new LinkedList<>();
        while (stack1.size() > 0 || stack2.size() > 0) {
            List<Integer> add = new LinkedList<>();
            if (flag) { //从1往2放，从左往右
                while (stack1.size() > 0) {
                    TreeNode pop = stack1.pop();
                    add.add(pop.val);
                    if (pop.left != null) {
                        stack2.push(pop.left);
                    }
                    if (pop.right != null) {
                        stack2.push(pop.right);
                    }
                }
            } else {  //从2往1放，从右往左
                while (stack2.size() > 0) {
                    TreeNode pop = stack2.pop();
                    add.add(pop.val);
                    if (pop.right != null) {
                        stack1.push(pop.right);
                    }
                    if (pop.left != null) {
                        stack1.push(pop.left);
                    }
                }
            }
            ans.add(add);
            flag = !flag;
        }
        return ans;
    }
}
