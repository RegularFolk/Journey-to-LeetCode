package NoteBook.SortingAlgorithm;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbs = new int[n];
        for (int i = 0; i < n; i++) {
            numbs[i] = sc.nextInt();
        }
        numbs = mergeSortForArray(numbs, 0, numbs.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(numbs[i]);
        }
    }

    public static int[] mergeSortForArray(int[] numbs, int left, int right) {//start from ZERO
        if (left == right) {        //注意这里的细节，已分解到最小单位
            return new int[]{numbs[left]};
        }
        int mid = (left + right) / 2;

        int[] rightNumbs = mergeSortForArray(numbs, mid + 1, right);
        int[] leftNumbs = mergeSortForArray(numbs, left, mid);

        int[] tempArray = new int[right - left + 1];
        int cursor = 0, leftCursor = 0, rightCursor = 0;
        while (leftCursor < rightNumbs.length && rightCursor < rightNumbs.length) {
            if (leftNumbs[leftCursor] < rightNumbs[rightCursor]) {
                tempArray[cursor] = leftNumbs[leftCursor];
                leftCursor++;
            } else {
                tempArray[cursor] = rightNumbs[rightCursor];
                rightCursor++;
            }
            cursor++;
        }
        if (leftCursor < leftNumbs.length) {
            while (leftCursor < leftNumbs.length) {
                tempArray[cursor] = leftNumbs[leftCursor];
                leftCursor++;
                cursor++;
            }
        } else {
            while (rightCursor < rightNumbs.length) {
                tempArray[cursor] = rightNumbs[rightCursor];
                rightCursor++;
                cursor++;
            }
        }
        return tempArray;
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

    public static ListNode mergeSortForLinkedList(ListNode head) {
        if (head == null || head.next == null) { //如果传入链表为空或者只有一个节点则不用处理
            return head;
        }

        //向寻找链表中间节点，利用快慢指针
        ListNode dummy = new ListNode(0, head);
        ListNode slowCursor = dummy;
        ListNode quickCursor = dummy;
        while (quickCursor != null && quickCursor.next != null) {
            quickCursor = quickCursor.next.next;
            slowCursor = slowCursor.next;
        }

        //利用递归将整条链表碎成最小长度为1的链表碎块
        ListNode right = mergeSortForLinkedList(slowCursor.next);
        slowCursor.next = null;  //此处断开链表
        ListNode left = mergeSortForLinkedList(head);

        //两两一组处理碎块
        ListNode tempHead = new ListNode(0); //创建临时链表头
        ListNode cursor = tempHead; //设置cursor的目的是需要记录临时链表头的位置，用于返回
        while (left != null && right != null) {  //比较到左右两个碎块有一个为空为止
            if (left.val < right.val) {
                cursor.next = left;
                left = left.next;
            } else {
                cursor.next = right;
                right = right.next;
            }
            cursor = cursor.next;
        }
        //将另一条还有剩下的链表连接到这条临时链表的尾部
        if (left != null) {
            cursor.next = left;
        } else {
            cursor.next = right;
        }

        return tempHead.next;
    }
}
