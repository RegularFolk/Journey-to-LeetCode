package Medium;


public class LC_148 {
    public static void main(String[] args) {
        //链表的归并排序

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

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        //首先寻找链表的中间节点
        ListNode slowCursor = dummy;
        ListNode quickCursor = dummy;
        while (quickCursor != null && quickCursor.next != null) {
            quickCursor = quickCursor.next.next;
            slowCursor = slowCursor.next;
        }           //slowCursor会指向中间节点

        //通过递归将一条链表不断拆分成一段一段碎片节点
        ListNode right = sortList(slowCursor.next);
        slowCursor.next = null;//这里将链表断开了
        ListNode left = sortList(head);

        //接下来要合并拆分掉的左右节点
        ListNode tempHead = new ListNode(0);  //利用tempHead做临时头节点，将断开的节点重新组合
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
        //接下来还要将左右没比完的一条家在后面
        if (left == null) {
            cursor.next = right;
        } else {
            cursor.next = left;
        }
        return tempHead.next;
    }

    public static int[] mergeSort(int[] numbs, int left, int right) {
        if (left == right)  //只有一个元素
            return new int[]{numbs[left]};

        int mid = left + (right - left) / 2;                            //找中点
        int[] leftArr = mergeSort(numbs, left, mid);                   //左有序数组
        int[] rightArr = mergeSort(numbs, mid + 1, right);        //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length];     //新有序数组,长度为之前排好序的左右加起来

        int m = 0, leftCursor = 0, rightCursor = 0;
        while (leftCursor < leftArr.length && rightCursor < rightArr.length) {
            newNum[m++] = leftArr[leftCursor] < rightArr[rightCursor] ? leftArr[leftCursor++] : rightArr[rightCursor++];
            //新数组的下一个位置取左右数组当前指着的元素的较小值
        }
        //比完了把还有一边剩下的加在新的数组末尾
        while (leftCursor < leftArr.length)
            newNum[m++] = leftArr[leftCursor++];
        while (rightCursor < rightArr.length)
            newNum[m++] = rightArr[rightCursor++];
        return newNum;
    }
}
