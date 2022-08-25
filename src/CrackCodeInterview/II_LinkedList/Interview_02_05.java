package CrackCodeInterview.II_LinkedList;

import DataStructure.ListNode;

public class Interview_02_05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode(0), cursor = ans;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val, v2 = l2 == null ? 0 : l2.val, sum = v1 + v2 + carry;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            carry = sum / 10;
            l1 = l1 == null || l1.next == null ? null : l1.next;
            l2 = l2 == null || l2.next == null ? null : l2.next;
        }
        return ans.next;
    }
}
