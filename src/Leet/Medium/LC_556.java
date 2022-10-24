package Leet.Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class LC_556 {


    @Test
    public void test() {
        System.out.println(nextGreaterElement1(2147483476));
    }

    public int nextGreaterElement(int n) {//可以确定比原本大，但是不能保证是最小的
        List<Integer> nums = apart(n);
        for (int i = nums.size() - 2; i >= 0; i--) {
            for (int j = nums.size() - 1; j > 0; j--) {
                if (nums.get(j) > nums.get(i)) {
                    swap(nums, i, j);
                    long res = form(nums);
                    return res > (long) Integer.MAX_VALUE ? -1 : (int) res;
                }
            }
        }
        return -1;
    }

    public int nextGreaterElement1(int n) { //找出从后往前第一个相邻递减数对，将其与后往前第一个比其大的数交换，再把该值后面序列翻转
        List<Integer> nums = apart(n);
        int index = -1, l, r;
        for (int i = nums.size() - 1; i > 0; i--) {
            if (nums.get(i) > nums.get(i - 1)) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            return -1;
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) > nums.get(index)) {
                swap(nums, i, index);
                break;
            }
        }
        l = index + 1;
        r = nums.size() - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
        long form = form(nums);
        return form > Integer.MAX_VALUE ? -1 : (int) form;
    }

    private long form(List<Integer> nums) {
        long res = 0;
        for (Integer num : nums) {
            res = res * 10 + num;
        }
        return res;
    }

    private List<Integer> apart(int n) {//正序将数拆开
        String string = Integer.toString(n);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            res.add(string.charAt(i) - '0');
        }
        return res;
    }
}
