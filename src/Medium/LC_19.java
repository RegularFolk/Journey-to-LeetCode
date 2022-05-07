package Medium;

public class LC_19 {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); //小技巧，设置dummy指向头指针之前，应对链表长度为1的特殊情况
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
        //使用快慢指针，一次遍历完成
        ListNode dummy = new ListNode(0, head);
        ListNode quickCursor = dummy;
        ListNode slowCursor = dummy;
        int step = 0;
        while (step < n && quickCursor.next != null) {  //快指针先走n步
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
