package Contest.YinLian_22_09_16;

import DataStructure.ListNode;

public class YinLian_1 {
    /*
     * ɾ�������ż���ڵ�
     *  */
    public ListNode reConstruct(ListNode head) {
        ListNode dummy = new ListNode(0), cursor = dummy;
        dummy.next = head;
        while (cursor.next != null) {
            if ((cursor.next.val & 1) == 0) {
                cursor.next = cursor.next.next;
            } else cursor = cursor.next;
        }
        return dummy.next;
    }
}
