package CrackCodeInterview.IV_Tree_Graph;

import DataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Interview_04_09_mark {

    @Test
    public void t() {
        List<List<Integer>> lists = BSTSequences2(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print("integer = " + integer + "///");
            }
            System.out.println('-');
        }
    }

    /*
    * 书本解法，直接爆栈
    * */
    public List<List<Integer>> BSTSequences1(TreeNode root) {
        ArrayList<LinkedList<Integer>> linkedLists = BSTSequencesHelper(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (LinkedList<Integer> linkedList : linkedLists) {
            List<Integer> add = (List<Integer>) linkedList.clone();
            ans.add(add);
        }
        return ans;
    }

    public ArrayList<LinkedList<Integer>> BSTSequencesHelper(TreeNode root) {
        ArrayList<LinkedList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            ans.add(new LinkedList<>());
            return ans;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);
        ArrayList<LinkedList<Integer>> left = BSTSequencesHelper(root.left);
        ArrayList<LinkedList<Integer>> right = BSTSequencesHelper(root.right);
        for (LinkedList<Integer> leftList : left) {
            for (LinkedList<Integer> rightList : right) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(leftList, rightList, weaved, prefix);
                ans.addAll(weaved);
            }
        }
        return ans;
    }

    private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        Integer headFirst = first.get(0);
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.remove(prefix.size() - 1);
        first.add(0, headFirst);

        Integer headSecond = second.get(0);
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.remove(prefix.size() - 1);
        second.add(0, headSecond);
    }

    private List<List<Integer>> ans;
    /*
    * 回溯法，结合层序遍历
    * */
    public List<List<Integer>> BSTSequences2(TreeNode root){
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 如果 root==null 返回 [[]]
        if (root == null) {
            ans.add(path);
            return ans;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 开始进行回溯
        bfs(queue, path);
        return ans;
    }

    /**
     * 回溯法+广度优先遍历.
     */
    private void bfs(List<TreeNode> queue, List<Integer> path) {
        // queue 为空说明遍历完了，可以返回了
        if (queue.isEmpty()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 将 queue 拷贝一份，用于稍后回溯
        List<TreeNode> copy = new ArrayList<>(queue);
        // 对 queue 进行循环，每循环考虑 “是否 「将当前 cur 节点从 queue 中取出并将其左右子
        // 节点加入 queue ，然后将 cur.val 加入到 path 末尾」 ” 的情况进行回溯
        for (int i = 0; i < queue.size(); i++) {
            TreeNode cur = queue.remove(i);//因为后面会恢复，所以这里要remove
            path.add(cur.val);
            // 将左右子节点加入队列，为了递归服务
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            bfs(queue, path);
            // 恢复 path 和 queue ，进行回溯
            path.remove(path.size() - 1);
            queue = new ArrayList<>(copy);
        }
    }

}
