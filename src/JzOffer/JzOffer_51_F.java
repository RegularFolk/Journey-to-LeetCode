package JzOffer;

import java.util.Arrays;

public class JzOffer_51_F {

    public int reversePairs(int[] nums) {  //结合排序,一边翻转逆序对一边计数
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return quickSort(nums, 0, nums.length - 1);
//        int[] copy = Arrays.copyOf(nums, nums.length);
//        return mergeSort(nums, copy, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] copy, int left, int right) {
        if (left == right) {
            copy[left] = nums[left];
            return 0;
        }
        int mid = (left + right) >> 1, count = 0;
        int ml = mergeSort(nums, copy, left, mid);
        int mr = mergeSort(nums, copy, mid + 1, right);
        int cur1 = mid, cur2 = right, cursor = right;
        while (cur1 >= left && cur2 >= mid + 1) {
            if (nums[cur1] <= nums[cur2]) {
                copy[cursor--] = nums[cur2--];
            } else {
                count += cur2 - left - mid;
                copy[cursor--] = nums[cur1--];
            }
        }
        while (cur1 >= left) {
            copy[cursor--] = nums[cur1--];
        }
        while (cur2 >= mid + 1) {
            copy[cursor--] = nums[cur2--];
        }
        return ml + mr + count;
    }

    private int quickSort(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0, lc = left, rc = right, pivot = nums[(left + right) >> 1];
        while (lc < rc) {
            while (nums[lc] < pivot) {
                lc++;
            }
            while (nums[rc] > pivot) {
                rc--;
            }
            if (lc <= rc) {
                if (lc < rc) {
                    count += rc - lc;
                }
                swap(nums, lc, rc);
                lc++;
                rc--;
            }
        }
        if (rc > left) {
            count += quickSort(nums, left, rc);
        }
        if (lc < right) {
            count += quickSort(nums, lc, right);
        }
        return count;
    }

    private void swap(int[] nums, int lc, int rc) {
        int temp = nums[lc];
        nums[lc] = nums[rc];
        nums[rc] = temp;
    }
}
