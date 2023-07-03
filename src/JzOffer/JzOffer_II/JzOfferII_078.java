package JzOffer.JzOffer_II;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JzOfferII_078 {
    /*
     * 每次都要取一个最小的头结点,
     * 可以考虑使用优先队列
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ArrayList<ListNode> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            if (listNode != null) list.add(listNode);
        }
        if (list.isEmpty()) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        heap.addAll(list);
        ListNode dummy = new ListNode(), cur = dummy;
        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            cur.next = poll;
            if (poll.next != null) heap.add(poll.next);
            cur = cur.next;
        }
        return dummy.next;
    }

    /*
     * 或者使用归并排序的思路
     * */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return doSort(lists, 0, lists.length - 1);
    }

    private ListNode doSort(ListNode[] lists, int l, int r) {
        if (l > r) return null;
        if (l == r) return lists[l];
        int mid = (l + r) >> 1;
        ListNode lNode = doSort(lists, l, mid);
        ListNode rNode = doSort(lists, mid + 1, r);
        ListNode dummy = new ListNode(), cur = dummy;
        while (lNode != null && rNode != null) {
            if (lNode.val <= rNode.val) {
                cur.next = lNode;
                lNode = lNode.next;
            } else {
                cur.next = rNode;
                rNode = rNode.next;
            }
            cur = cur.next;
        }
        cur.next = lNode == null ? rNode : lNode;
        return dummy.next;
    }
}
