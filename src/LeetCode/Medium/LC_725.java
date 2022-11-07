package LeetCode.Medium;

import DataStructure.ListNode;
import org.junit.Test;

public class LC_725 {
    /*
     * Ä£Äâ,·±Ëö
     * */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode(0), cursor = dummy;
        dummy.next = head;
        while (cursor.next != null) {
            count++;
            cursor = cursor.next;
        }
        int part = count / k, left = k > count ? k : count - part * k;
        ListNode[] ans = new ListNode[k];
        cursor = dummy;
        for (int i = 0; i < ans.length && dummy != null; i++) {
            for (int j = 0; j < part + (left > 0 ? 1 : 0) && cursor != null; j++) {
                cursor = cursor.next;
            }
            left--;
            ans[i] = dummy.next;
            if (cursor == null) dummy = null;
            else {
                dummy.next = cursor.next;
                cursor.next = null;
                cursor = dummy;
            }
        }
        return ans;
    }

    @Test
    public void x() {
        ListNode[] listNodes = splitListToParts(ListNode.formLinkedList("[1,2,3,4,5,6,7]"), 3);
        for (ListNode listNode : listNodes) {
            System.out.println(listNode.val);
        }
    }
}
