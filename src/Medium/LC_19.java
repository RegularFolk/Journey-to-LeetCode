package Medium;

import DataStructure.ListNode;

public class LC_19 {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); //С���ɣ�����dummyָ��ͷָ��֮ǰ��Ӧ��������Ϊ1���������
        ListNode cursor = dummy;
        int total = 0;
        while (head != null) {
            head = head.next;
            total++;
        }
        for (int i = 1; i < total - n + 1; i++) {
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        //ʹ�ÿ���ָ�룬һ�α������
        ListNode dummy = new ListNode(0, head);
        ListNode quickCursor = dummy;
        ListNode slowCursor = dummy;
        int step = 0;
        while (step < n && quickCursor.next != null) {  //��ָ������n��
            quickCursor = quickCursor.next;
            step++;
        }
        while (quickCursor.next != null) {
            slowCursor = slowCursor.next;
            quickCursor = quickCursor.next;
        }
        slowCursor.next = slowCursor.next.next;
        return dummy.next;
    }
}
