package CrackCodeInterview;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Interview_02_06 {
    public boolean isPalindrome1(ListNode head) {//时间复杂度和空间复杂度均为n
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

    public boolean isPalindrome2(ListNode head) { //时间复杂度为n，空间复杂度为1，利用快慢指针,翻转一半
        //TODO 繁琐
        return true;
    }
}
