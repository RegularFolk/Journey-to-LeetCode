package Leet.Medium;


import DataStructure.ListNode;

public class LC_148 {
    public static void main(String[] args) {
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode slowCursor = dummy;
        ListNode quickCursor = dummy;
        while (quickCursor != null && quickCursor.next != null) {
            quickCursor = quickCursor.next.next;
            slowCursor = slowCursor.next;
        }

        ListNode right = sortList(slowCursor.next);
        slowCursor.next = null;
        ListNode left = sortList(head);

        ListNode tempHead = new ListNode(0);
        ListNode cursor = tempHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cursor.next = left;
                left = left.next;
            } else {
                cursor.next = right;
                right = right.next;
            }
            cursor = cursor.next;
        }
        if (left == null) {
            cursor.next = right;
        } else {
            cursor.next = left;
        }
        return tempHead.next;
    }

    public static int[] mergeSort(int[] numbs, int left, int right) {
        if (left == right)
            return new int[]{numbs[left]};

        int mid = left + (right - left) / 2;
        int[] leftArr = mergeSort(numbs, left, mid);
        int[] rightArr = mergeSort(numbs, mid + 1, right);
        int[] newNum = new int[leftArr.length + rightArr.length];

        int m = 0, leftCursor = 0, rightCursor = 0;
        while (leftCursor < leftArr.length && rightCursor < rightArr.length) {
            newNum[m++] = leftArr[leftCursor] < rightArr[rightCursor] ? leftArr[leftCursor++] : rightArr[rightCursor++];
        }
        while (leftCursor < leftArr.length)
            newNum[m++] = leftArr[leftCursor++];
        while (rightCursor < rightArr.length)
            newNum[m++] = rightArr[rightCursor++];
        return newNum;
    }
}
