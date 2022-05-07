package Medium;

import java.util.List;

public class LC_24 {
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

    public static ListNode swapPairs(ListNode head) {  //穿针引线，织毛衣
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode temp;
        while (left != null && right != null) {
            if (before == left) {  //头两个节点
                left.next = right.next;
                right.next = left;
                head = right;    //头要指向链表更新后的头节点
                //before 在第一次变换完不用动，小细节！
            } else {
                before.next = right;
                left.next = right.next;
                right.next = left;
                before = before.next.next;
            }
            temp = right;  //交换之后左右指针会变成右左指针，需要换回来
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
