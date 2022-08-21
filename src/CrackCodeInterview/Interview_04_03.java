package CrackCodeInterview;

import DataStructure.ListNode;
import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Interview_04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {//层序遍历
        if (tree == null) {
            return new ListNode[0];
        }
        List<ListNode> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int cur = 1, next = 0;
        while (cur != 0) {
            ListNode head = new ListNode(0), cursor = head;
            while (cur-- > 0) {
                TreeNode poll = queue.poll();
                cursor.next = new ListNode(poll.val);
                cursor = cursor.next;
                if (poll.left != null) {
                    next++;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    next++;
                    queue.add(poll.right);
                }
            }
            cur = next;
            next = 0;
            ans.add(head.next);
        }
        return ans.toArray(ListNode[]::new);
    }
}
