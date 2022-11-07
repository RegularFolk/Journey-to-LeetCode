package LeetCode.Hard;

import DataStructure.ListNode;
import org.junit.Test;

public class LC_23_mark {
    /*
     * 分治法，类似于MergeSort
     * 十分钟秒杀困难！！！！！！！！！！！！！！！！！！！！！！！！！！
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return lists[l];
        } else if (l + 1 == r) {
            return doMerge(lists[l], lists[r]);
        } else {
            int mid = (l + r) >> 1;
            ListNode left = merge(lists, l, mid);
            ListNode right = merge(lists, mid + 1, r);
            return doMerge(left, right);
        }
    }

    private ListNode doMerge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummy = new ListNode(0), cursor = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cursor.next = list1;
                list1 = list1.next;
            } else {
                cursor.next = list2;
                list2 = list2.next;
            }
            cursor = cursor.next;
        }
        cursor.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    @Test
    public void s() {
        ListNode listNode = mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))});
        while (listNode != null) {
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }
}
