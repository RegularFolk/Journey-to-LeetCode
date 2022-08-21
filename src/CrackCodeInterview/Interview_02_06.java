package CrackCodeInterview;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Interview_02_06 {
    public boolean isPalindrome1(ListNode head) {//ʱ�临�ӶȺͿռ临�ӶȾ�Ϊn
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int left = 0, right = list.size() - 1; left < right; left++, right--) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) { //ʱ�临�Ӷ�Ϊn���ռ临�Ӷ�Ϊ1�����ÿ���ָ��,��תһ��
        //TODO ����
        return true;
    }
}
