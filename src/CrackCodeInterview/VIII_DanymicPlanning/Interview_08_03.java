package CrackCodeInterview.VIII_DanymicPlanning;

import org.junit.Test;

public class Interview_08_03 {
    /*
     * 有序，所以要结合二分查找
     * */
    public int findMagicIndex(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) >> 1;
        //先再左边找，再在右边找，左边取较小，右边取较大
        int leftValue = find(nums, left, Math.min(mid - 1, nums[mid]));
        if (leftValue >= 0) {
            return leftValue;
        } else if (mid == nums[mid]) {
            return mid;//即使当前已相等，得先确认左边没有才可以确认是最小答案
        }
        return find(nums, Math.max(mid + 1, nums[mid]), right);
    }

    @Test
    public void t() {
        int index = findMagicIndex(new int[]{-99, -87, -69, -51, -40, -38, -31, -30, -18, -1, 10, 11, 41, 63, 71, 72, 72, 78, 86, 88});
        System.out.println("index = " + index);
    }
}
