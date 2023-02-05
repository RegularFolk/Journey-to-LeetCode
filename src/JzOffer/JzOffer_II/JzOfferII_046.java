package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JzOfferII_046 {

    /*
    * ¶þ²æÊ÷µÄ²ãÐò±éÀú
    * */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        cur.addLast(root);
        while (!cur.isEmpty()) {
            while (!cur.isEmpty()) {
                TreeNode curFirst = cur.removeFirst();
                if (curFirst.left != null) next.addLast(curFirst.left);
                if (curFirst.right != null) next.addLast(curFirst.right);
            }
            if (!next.isEmpty()) ans.add(next.getLast().val);
            cur = next;
            next = new LinkedList<>();
        }
        return ans;
    }
}
