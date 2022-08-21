package CrackCodeInterview;

import DataStructure.ListNode;

public class Interview_02_04 {
    public ListNode partition1(ListNode head, int x) {  //使用n额外空间
        if (head == null) {
            return null;
        }
        ListNode list1 = new ListNode(0), list2 = new ListNode(0), cur1 = list1, cur2 = list2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = new ListNode(head.val);
                cur1 = cur1.next;
            } else {
                cur2.next = new ListNode(head.val);
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = list2.next;
        return list1.next;
    }

    public ListNode partition2(ListNode head, int x) {  //不使用额外空间,将大的移到链表尾部，穿针引线
        if (head == null) {
            return null;
        }
        ListNode tail = head, dummy = new ListNode(0), cursor = dummy;//计数完后停在尾部
        dummy.next = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        while (len-- > 0) {
            if (cursor.next.val >= x) {
                tail.next = cursor.next;
                cursor.next = cursor.next.next;
                tail = tail.next;
                tail.next = null;
            } else {
                cursor = cursor.next;
            }
        }
        return dummy.next;
    }
}
