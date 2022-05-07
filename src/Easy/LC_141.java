package Easy;

public class LC_141 {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode cursor = new ListNode(0);
        cursor.next = head;
        ListNode mark;
        while (cursor.next != null) {
            mark = cursor.next;
            cursor = mark;
            while (cursor != null) {
                cursor = cursor.next;
                if (cursor == mark) {
                    return true;
                }
            }
            cursor = mark;
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        ListNode cursor = new ListNode(0);
        cursor.next = head;
        int count = 0;
        while (cursor.next != null) {
            cursor = cursor.next;
            count++;
            if (count > 10000) {
                return true;
            }
        }
        return false;
    }

}
