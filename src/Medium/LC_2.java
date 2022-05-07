package Medium;

public class LC_2 {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cursor = head; //游标，用于往后创建
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        boolean flag1 = false;  //用于分辨两条链表是否到头
        boolean flag2 = false;
        boolean flag = false;  //进位标识
        boolean fir = true;   //处理头节点
        int sum;               //求和
        while (!flag1 || !flag2) {
            if (flag1) {
                sum = cursor2.val;
            } else if (flag2) {
                sum = cursor1.val;
            } else {
                sum = cursor1.val + cursor2.val;
            }
            if (flag) {              //上一次加产生了进位
                sum++;
            }
            if (fir) {     //第一次相加
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
        if (flag) { //如果最后一个还剩下一个进位没有处理，再在后面加一个节点
            cursor.next = new ListNode(1);
        }
        return head;
    }
}