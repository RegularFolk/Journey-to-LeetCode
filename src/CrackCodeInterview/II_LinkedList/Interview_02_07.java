package CrackCodeInterview.II_LinkedList;

import DataStructure.ListNode;

public class Interview_02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLen(headA), lenB = getLen(headB), gap = Math.abs(lenA - lenB);
        if (lenB > lenA) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        while (gap-- > 0) {
            headA = headA.next;
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    private int getLen(ListNode head) {
        int ans = 0;
        while (head != null) {
            head = head.next;
            ans++;
        }
        return ans;
    }
}
