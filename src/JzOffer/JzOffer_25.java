package JzOffer;

import DataStructure.ListNode;

public class JzOffer_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), cur = ans;
        while (l1 != null && l2 != null) {
            int num;
            if (l1.val <= l2.val) {
                num = l1.val;
                l1 = l1.next;
            } else {
                num = l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return ans.next;
    }
}
