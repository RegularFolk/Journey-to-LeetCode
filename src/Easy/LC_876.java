package Easy;

import DataStructure.ListNode;

public class LC_876 {
    /*
     * ������м�ڵ㣬���ÿ���ָ��
     * ������Ŀ
     * */
    public ListNode middleNode(ListNode head) {
        if (head.next == null || head.next.next == null) return head.next == null ? head : head.next;
        ListNode s = new ListNode(0), f = new ListNode(0);
        s.next = head;
        f.next = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return f == null ? s : s.next;
    }
}
