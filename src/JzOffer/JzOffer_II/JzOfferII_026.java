package JzOffer.JzOffer_II;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class JzOfferII_026 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode prev = new ListNode();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            prev.next = list.get(l++);
            prev = prev.next;
            prev.next = list.get(r--);
            prev = prev.next;
        }
        if (l == r) {
            prev.next = list.get(l);
            prev = prev.next;
        }
        prev.next = null;
    }
}
