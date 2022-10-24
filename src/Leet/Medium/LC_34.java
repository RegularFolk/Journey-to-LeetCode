package Leet.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_34 {
    /*
     * Ë«ÖØ¶ş·Ö
     * */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                pos = mid;
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                pos = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }

    @Test
    public void s() {
        int[] ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
