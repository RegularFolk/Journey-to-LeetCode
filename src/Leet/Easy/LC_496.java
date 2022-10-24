package Leet.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC_496 {

    /*
     * 单调栈简单应用
     * 先对nums2跑一遍建立散列表，然后按照nums1填入ans中
     * */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
