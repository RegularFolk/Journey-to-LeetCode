package LeetCode.Medium;

import org.junit.Test;

public class LC_80 {
    public static int removeDuplicates(int[] nums) {
        int cnt = 0, idx = 0, mark = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == mark && i - idx > 1) {
                cnt++;
                nums[i] = Integer.MIN_VALUE;
            } else if (nums[i] != mark) {
                mark = nums[i];
                idx = i;
            }
        }
        // 双指针，对标记后的数组修改
        int l = 0, r = 0;
        while (l < nums.length && r < nums.length) {
            while (l < nums.length && nums[l] != Integer.MIN_VALUE) {
                l++;
            }
            while (r < nums.length && (nums[r] == Integer.MIN_VALUE || r <= l)) {
                r++;
            }
            if (l < nums.length && r < nums.length) {
                nums[l] = nums[r];
                nums[r] = Integer.MIN_VALUE;
                l++;
                r++;
            }
        }
        return nums.length - cnt;
    }

    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println("i = " + i);
    }
}
