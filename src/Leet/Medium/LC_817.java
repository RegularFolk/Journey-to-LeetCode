package Leet.Medium;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC_817 {
    public int numComponents(ListNode head, int[] nums) {
        // nums放在HashSet里
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        // 链表指针p往后走，当前值在set中，而下一个不在set中 或 到达尾部时，更新count
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) count++;
            head = head.next;
        }
        return count;
    }
}
