package LeetCode.Easy;

import DataStructure.Node;

import java.util.LinkedList;
import java.util.List;

public class LC_590 {
    /*
     * N²æÊ÷µÄºóÐò±éÀú
     * */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        postTravel(root, list);
        return list;
    }

    private void postTravel(Node root, List<Integer> list) {
        if (root != null) {
            for (Node child : root.children) {
                postTravel(child, list);
            }
            list.add(root.val);
        }
    }
}
