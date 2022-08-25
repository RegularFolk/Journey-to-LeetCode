package Medium;


import DataStructure.ListNode;

public class LC_148 {
    public static void main(String[] args) {
        //����Ĺ鲢����

    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        //����Ѱ��������м�ڵ�
        ListNode slowCursor = dummy;
        ListNode quickCursor = dummy;
        while (quickCursor != null && quickCursor.next != null) {
            quickCursor = quickCursor.next.next;
            slowCursor = slowCursor.next;
        }           //slowCursor��ָ���м�ڵ�

        //ͨ���ݹ齫һ�������ϲ�ֳ�һ��һ����Ƭ�ڵ�
        ListNode right = sortList(slowCursor.next);
        slowCursor.next = null;//���ｫ����Ͽ���
        ListNode left = sortList(head);

        //������Ҫ�ϲ���ֵ������ҽڵ�
        ListNode tempHead = new ListNode(0);  //����tempHead����ʱͷ�ڵ㣬���Ͽ��Ľڵ��������
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
        //��������Ҫ������û�����һ�����ں���
        if (left == null) {
            cursor.next = right;
        } else {
            cursor.next = left;
        }
        return tempHead.next;
    }

    public static int[] mergeSort(int[] numbs, int left, int right) {
        if (left == right)  //ֻ��һ��Ԫ��
            return new int[]{numbs[left]};

        int mid = left + (right - left) / 2;                            //���е�
        int[] leftArr = mergeSort(numbs, left, mid);                   //����������
        int[] rightArr = mergeSort(numbs, mid + 1, right);        //����������
        int[] newNum = new int[leftArr.length + rightArr.length];     //����������,����Ϊ֮ǰ�ź�������Ҽ�����

        int m = 0, leftCursor = 0, rightCursor = 0;
        while (leftCursor < leftArr.length && rightCursor < rightArr.length) {
            newNum[m++] = leftArr[leftCursor] < rightArr[rightCursor] ? leftArr[leftCursor++] : rightArr[rightCursor++];
            //���������һ��λ��ȡ�������鵱ǰָ�ŵ�Ԫ�صĽ�Сֵ
        }
        //�����˰ѻ���һ��ʣ�µļ����µ�����ĩβ
        while (leftCursor < leftArr.length)
            newNum[m++] = leftArr[leftCursor++];
        while (rightCursor < rightArr.length)
            newNum[m++] = rightArr[rightCursor++];
        return newNum;
    }
}
