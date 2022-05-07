package Medium;

public class LC_82 {
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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cursor = dummy;
        boolean flag = false;
        while (cursor.next != null && cursor.next.next != null) {
            if (flag && cursor.next.val != cursor.next.next.val) {
                cursor.next = cursor.next.next;
                flag = false;
            } else if (cursor.next.val == cursor.next.next.val) {
                cursor.next = cursor.next.next;
                if (!flag) {
                    flag = true;
                }
            } else {
                cursor = cursor.next;
            }
        }
        if (flag) {
            cursor.next = null;
        }
        return dummy.next;
    }
}
