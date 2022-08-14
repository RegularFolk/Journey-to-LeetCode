package JzOffer;

import DataStructure.ListNode;

public class JzOffer_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLen(headA), lenB = getLen(headB);
        if (lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int gap = Math.abs(lenA - lenB);
        while (gap-- > 0) {
            headA = headA.next;
        }
        while (headA != null && headB != null) {
            if (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            } else {
                return headA;
            }
        }
        return null;
    }

    private int getLen(ListNode node) {
        int ans = 0;
        while (node != null) {
            ans++;
            node = node.next;
        }
        return ans;
    }
}
