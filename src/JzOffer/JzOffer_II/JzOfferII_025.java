package JzOffer.JzOffer_II;

import DataStructure.ListNode;

import java.util.Stack;

public class JzOfferII_025 {
    /*
    * 反着加，符合后进先出，利用栈
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode cur = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int sum = (!s1.isEmpty() ? s1.pop().val : 0) + (!s2.isEmpty() ? s2.pop().val : 0) + carry;
            carry = sum / 10;
            ListNode add = new ListNode();
            add.val = sum % 10;
            add.next = cur;
            cur = add;
        }
        return cur;
    }
}
