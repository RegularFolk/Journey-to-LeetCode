package Leet.Medium;

import DataStructure.ListNode;

import java.util.Stack;

public class LC_1019 {
    /*
     * 单调栈模板题，维护一个从栈底到栈顶递减的栈
     * */
    public int[] nextLargerNodes(ListNode head) {
        int[] ans = new int[getLen(head)];
        Stack<int[]> stack = new Stack<>();//[index,val]
        int count = 0;
        while (head != null) {
            while (!stack.isEmpty() && stack.peek()[1] < head.val) {
                ans[stack.pop()[0]] = head.val;
            }
            stack.push(new int[]{count++, head.val});
            head = head.next;
        }
        return ans;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
