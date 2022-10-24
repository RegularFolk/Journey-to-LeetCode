package JzOffer.JzOffer_I;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class JzOffer_06 {

    //法一，直接把链表翻转
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        } else if (head.next == null) {
            return new int[]{head.val};
        }
        ListNode l = head, m = head.next, r = head.next.next;
        int len = 0;
        l.next = null;
        while (m != null) {
            m.next = l;
            l = m;
            m = r;
            r = r == null ? null : r.next;
            len++;
        }
        int[] ans = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            ans[i] = l.val;
            l = l.next;
        }
        return ans;
    }

    //法二，后进先出，利用栈  （居然比翻转要慢）
    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
            len++;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    //法三，在栈的基础上更进一步，使用递归,就是这个ArrayList在递归过程中需要特别处理
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans = recursive(head, ans);
        int[] arr = new int[ans.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    private ArrayList<Integer> recursive(ListNode head, ArrayList<Integer> ans) {
        if (head.next != null) {
            ans = recursive(head.next, ans);
        }
        ans.add(head.val);
        return ans;
    }


}
