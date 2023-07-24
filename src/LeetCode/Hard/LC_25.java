package LeetCode.Hard;

import DataStructure.ListNode;

@SuppressWarnings("UnnecessaryLocalVariable")
public class LC_25 {
    /*
     * 需要捋清楚思路
     *
     * 1 判断链表剩余长度是否大于等于k
     * 2 如何翻转中间一段？
     *   2.1 首先把中间一段拆出来
     *   2.2 中间一段翻转后再拼回去
     * 3 需要记录的节点：当前这一段的前驱节点，当前这一段的后继节点，当前这一段的头结点
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummy = new ListNode(0, head), cursor = dummy, prev = dummy, next = prev;
        while ((cursor = kLen(cursor, k)) != null) { //剩余长度大于等于k
            // 拆出当前这一段，此时cursor位于这一段最后一个节点
            ListNode lead = prev.next;// 记录本段的开头
            next = cursor.next;// 记录下一段的开头
            prev.next = null;// 断开前面
            cursor.next = null;// 断开后面

            ListNode newLead = reverse(lead);// 翻转中间一段

            prev.next = newLead; // 翻转后前面部分接上
            lead.next = next; // 翻转后后面部分接上，原先的头变成了现在的尾
            cursor = lead; // 移动cursor的位置到翻转后的末尾
            prev = lead; // 移动prev的位置到翻转后的末尾
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
