package Leet.Medium;

import DataStructure.ListNode;

public class LC_1669 {
    /*
     * Á´±íµÄÄ£Äâ
     * */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0), cursor = dummy, nodeA = null, nodeB;
        dummy.next = list1;
        int count = 0;
        while (count <= b) {
            if (count == a) nodeA = cursor;
            cursor = cursor.next;
            count++;
        }
        nodeB = cursor.next;
        cursor = list2;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = nodeB;
        nodeA.next = list2;
        return dummy.next;
    }
}
