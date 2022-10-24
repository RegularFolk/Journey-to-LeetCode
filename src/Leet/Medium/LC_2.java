package Leet.Medium;

import DataStructure.ListNode;

public class LC_2 {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cursor = head; //�α꣬�������󴴽�
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        boolean flag1 = false;  //���ڷֱ����������Ƿ�ͷ
        boolean flag2 = false;
        boolean flag = false;  //��λ��ʶ
        boolean fir = true;   //����ͷ�ڵ�
        int sum;               //���
        while (!flag1 || !flag2) {
            if (flag1) {
                sum = cursor2.val;
            } else if (flag2) {
                sum = cursor1.val;
            } else {
                sum = cursor1.val + cursor2.val;
            }
            if (flag) {              //��һ�μӲ����˽�λ
                sum++;
            }
            if (fir) {     //��һ�����
                head.val = sum % 10;
                fir = false;
            } else {
                cursor.next = new ListNode();
                cursor = cursor.next;
                cursor.val = sum % 10;
            }
            flag = sum >= 10;

            if (cursor1.next == null) {
                flag1 = true;
            } else {
                cursor1 = cursor1.next;
            }
            if (cursor2.next == null) {
                flag2 = true;
            } else {
                cursor2 = cursor2.next;
            }
        }
        if (flag) { //������һ����ʣ��һ����λû�д������ں����һ���ڵ�
            cursor.next = new ListNode(1);
        }
        return head;
    }
}