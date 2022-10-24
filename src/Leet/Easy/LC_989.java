package Leet.Easy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LC_989 {
    /*
     * Ä£Äâ
     * */
    public List<Integer> addToArrayForm(int[] num, int k) {
        int cursor = num.length - 1, carry = 0;
        while (cursor >= 0) {
            int sum = num[cursor] + k % 10 + carry;
            num[cursor] = sum % 10;
            carry = sum / 10;
            k /= 10;
            cursor--;
        }
        int head = k + carry;
        LinkedList<Integer> ans = new LinkedList<>();
        while (head > 0) {
            ans.addFirst(head % 10);
            head /= 10;
        }
        for (int i : num) {
            ans.add(i);
        }
        return ans;
    }

    @Test
    public void x() {
        List<Integer> list = addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
