package Leet.Medium;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC_817 {
    public int numComponents(ListNode head, int[] nums) {
        // nums����HashSet��
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        // ����ָ��p�����ߣ���ǰֵ��set�У�����һ������set�� �� ����β��ʱ������count
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) count++;
            head = head.next;
        }
        return count;
    }
}
