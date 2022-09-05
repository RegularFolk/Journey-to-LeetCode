package Medium;

import DataStructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_429 {
    /*
     * N²æÊ÷µÄ²ãÐò±éÀú
     * */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int cur = 1, next = 0;
        while (q.size() > 0) {
            List<Integer> add = new ArrayList<>();
            while (cur-- > 0) {
                Node poll = q.poll();
                add.add(poll.val);
                next += poll.children.size();
                q.addAll(poll.children);
            }
            ans.add(add);
            cur = next;
            next = 0;
        }
        return ans;
    }
}
