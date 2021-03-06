package JzOffer;

public class JzOffer_027 {
    public static void main(String[] args) {
        //��Interview_02_06һ��һ��

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

    public static boolean isPalindrome(ListNode head){
        //ʱ�临�Ӷ�Ϊ2n
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }

        ListNode ahead = head;
        ListNode half = head;
        int step = 0;
        while (ahead != null) {             //��ȡ�м�ָ��
            if (step == 2) {
                half = half.next;
                step = 0;
            }
            ahead = ahead.next;
            step++;
        }

        ListNode newHead = null;
        while (half.next != null) {
            half = half.next;
            ListNode temp = new ListNode(half.val);
            temp.next = newHead;
            newHead = temp;
        }
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            } else {
                newHead = newHead.next;
                head = head.next;
            }
        }
        return true;
    }

}
