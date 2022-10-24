package Leet.Easy;

import DataStructure.Node;

import java.util.LinkedList;
import java.util.List;

public class LC_589 {
    /*
     * N²æÊ÷µÄÇ°Ðò±éÀú
     * */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preTravel(root, list);
        return list;
    }

    private void preTravel(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            for (Node child : root.children) {
                preTravel(child, list);
            }
        }
    }
}
