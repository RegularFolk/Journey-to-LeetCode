package JzOffer.JzOffer_II;

import DataStructure.Node;

public class JzOfferII_028 {
    /*
     * Á´±í+DFS
     * */
    Node prev = new Node();//×ÜÁ´

    public Node flatten(Node head) {
        Node cursor = head;
        while (cursor != null) {
            prev.next = cursor;
            prev = cursor;
            Node next = cursor.next;
            if (cursor.child != null) {
                Node children = flatten(cursor.child);
                cursor.child = null;
                children.prev = cursor;
                if (next != null) next.prev = prev;
            }
            cursor = next;
        }
        return head;
    }
}
