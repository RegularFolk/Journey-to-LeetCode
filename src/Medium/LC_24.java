package Medium;

import DataStructure.ListNode;

import java.util.List;

public class LC_24 {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {  //�������ߣ�֯ë��
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode temp;
        while (left != null && right != null) {
            if (before == left) {  //ͷ�����ڵ�
                left.next = right.next;
                right.next = left;
                head = right;    //ͷҪָ��������º��ͷ�ڵ�
                //before �ڵ�һ�α任�겻�ö���Сϸ�ڣ�
            } else {
                before.next = right;
                left.next = right.next;
                right.next = left;
                before = before.next.next;
            }
            temp = right;  //����֮������ָ���������ָ�룬��Ҫ������
            right = left;
            left = temp;
            if (right.next != null) {
                right = right.next.next;
            } else {
                break;
            }
            left = left.next.next;
        }
        return head;
    }
}
