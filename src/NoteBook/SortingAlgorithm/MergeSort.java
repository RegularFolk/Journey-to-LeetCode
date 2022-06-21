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
        if (left == right) {        //ע�������ϸ�ڣ��ѷֽ⵽��С��λ
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
        if (head == null || head.next == null) { //�����������Ϊ�ջ���ֻ��һ���ڵ����ô���
            return head;
        }

        //��Ѱ�������м�ڵ㣬���ÿ���ָ��
        ListNode dummy = new ListNode(0, head);
        ListNode slowCursor = dummy;
        ListNode quickCursor = dummy;
        while (quickCursor != null && quickCursor.next != null) {
            quickCursor = quickCursor.next.next;
            slowCursor = slowCursor.next;
        }

        //���õݹ齫�������������С����Ϊ1���������
        ListNode right = mergeSortForLinkedList(slowCursor.next);
        slowCursor.next = null;  //�˴��Ͽ�����
        ListNode left = mergeSortForLinkedList(head);

        //����һ�鴦�����
        ListNode tempHead = new ListNode(0); //������ʱ����ͷ
        ListNode cursor = tempHead; //����cursor��Ŀ������Ҫ��¼��ʱ����ͷ��λ�ã����ڷ���
        while (left != null && right != null) {  //�Ƚϵ��������������һ��Ϊ��Ϊֹ
            if (left.val < right.val) {
                cursor.next = left;
                left = left.next;
            } else {
                cursor.next = right;
                right = right.next;
            }
            cursor = cursor.next;
        }
        //����һ������ʣ�µ��������ӵ�������ʱ�����β��
        if (left != null) {
            cursor.next = left;
        } else {
            cursor.next = right;
        }

        return tempHead.next;
    }
}
