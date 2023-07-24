package LeetCode.Hard;

import DataStructure.ListNode;

@SuppressWarnings("UnnecessaryLocalVariable")
public class LC_25 {
    /*
     * ��Ҫ�����˼·
     *
     * 1 �ж�����ʣ�೤���Ƿ���ڵ���k
     * 2 ��η�ת�м�һ�Σ�
     *   2.1 ���Ȱ��м�һ�β����
     *   2.2 �м�һ�η�ת����ƴ��ȥ
     * 3 ��Ҫ��¼�Ľڵ㣺��ǰ��һ�ε�ǰ���ڵ㣬��ǰ��һ�εĺ�̽ڵ㣬��ǰ��һ�ε�ͷ���
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummy = new ListNode(0, head), cursor = dummy, prev = dummy, next = prev;
        while ((cursor = kLen(cursor, k)) != null) { //ʣ�೤�ȴ��ڵ���k
            // �����ǰ��һ�Σ���ʱcursorλ����һ�����һ���ڵ�
            ListNode lead = prev.next;// ��¼���εĿ�ͷ
            next = cursor.next;// ��¼��һ�εĿ�ͷ
            prev.next = null;// �Ͽ�ǰ��
            cursor.next = null;// �Ͽ�����

            ListNode newLead = reverse(lead);// ��ת�м�һ��

            prev.next = newLead; // ��ת��ǰ�沿�ֽ���
            lead.next = next; // ��ת����沿�ֽ��ϣ�ԭ�ȵ�ͷ��������ڵ�β
            cursor = lead; // �ƶ�cursor��λ�õ���ת���ĩβ
            prev = lead; // �ƶ�prev��λ�õ���ת���ĩβ
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode lead) {
        /*
        *   <-prev cur-> next->
        * */
        ListNode prev = null, cur = lead, next = lead.next;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    private ListNode kLen(ListNode cursor, int k) {
        while (cursor != null && k-- > 0) {
            cursor = cursor.next;
        }
        return cursor;
    }

}
