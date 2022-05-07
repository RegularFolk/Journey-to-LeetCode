package Easy;

public class LC_234 {
    public static void main(String[] args) {
        //��Interview_02_06һ��һ��

    }

    public static class ListNode {
        int val;
        JzOffer_027.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, JzOffer_027.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(JzOffer_027.ListNode head){
        //ʱ�临�Ӷ�Ϊ2n
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }

        JzOffer_027.ListNode ahead = head;
        JzOffer_027.ListNode half = head;
        int step = 0;
        while (ahead != null) {             //��ȡ�м�ָ��
            if (step == 2) {
                half = half.next;
                step = 0;
            }
            ahead = ahead.next;
            step++;
        }

        JzOffer_027.ListNode newHead = null;
        while (half.next != null) {
            half = half.next;
            JzOffer_027.ListNode temp = new JzOffer_027.ListNode(half.val);
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
