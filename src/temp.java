import java.util.Arrays;

public class temp {

    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        if (digits[len] < 9) {
            digits[len]++;
        } else {
            digits[len] = 0;
            len--;
            while (len >= 0 && digits[len] == 9) {
                digits[len] = 0;
                len--;
            }
            if (len >= 0) {
                digits[len]++;
            }
        }
        if (digits[0] == 0) {
            int[] replace = new int[digits.length + 1];
            replace[0] = 1;
            for (int i = 1; i < replace.length; i++) {
                replace[i] = 0;
            }
            return replace;
        } else {
            return digits;
        }
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode front = head.next;
        ListNode tail = head;
        while (front != null) {
            if (front.val != tail.val) {
                front = front.next;
                tail = tail.next;
            } else {
                tail.next = front.next;
                front = tail.next;
            }
        }
        return head;
    }

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return 0;
        }
        int minx = ops[0][0], miny = ops[0][1];
        for (int[] op : ops) {
            minx = Math.min(op[0], minx);
            miny = Math.min(op[1], miny);
        }
        return minx * miny;
    }

}
