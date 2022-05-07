package Medium;

public class LC_328 {
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

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode mark = head.next;
        ListNode cursor = dummy;
        ListNode temp;
        boolean odd = true;
        while (cursor.next != null) {
            if (cursor == dummy) {
                cursor = cursor.next;
            }
            temp = cursor.next;
            if (cursor.next.next != null) {
                cursor.next = cursor.next.next;
                cursor = temp;
                odd = !odd;
            } else {
                if (odd) {  //在奇数节点结束
                    cursor.next = mark;
                } else {   //偶数节点结束
                    cursor.next = null;
                    temp.next = mark;
                }
                break;
            }
        }
        return dummy.next;
    }
}
