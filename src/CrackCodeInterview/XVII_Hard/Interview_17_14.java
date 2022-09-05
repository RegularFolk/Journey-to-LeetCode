package CrackCodeInterview.XVII_Hard;

import org.junit.Test;

import java.util.Arrays;

public class Interview_17_14 {
    /*
     * 基于快速排序的快速选择
     * */
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) return new int[]{};
        if (arr == null || arr.length == 0) return new int[]{};
        find(arr, k - 1, 0, arr.length - 1);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, ans.length);
        return ans;
    }

    private void find(int[] arr, int tar, int left, int right) {
        int pos = partition(arr, left, right);
        if (pos == tar) return;
        if (pos > tar) {
            find(arr, tar, left, pos - 1);
        } else {
            find(arr, tar, pos + 1, right);
        }
    }

    /*
     * 左边小于，右边大于等于
     * */
    private int partition(int[] arr, int left, int right) {
        int l = left + 1, r = right;
        while (l < r) {
            while (l < right && arr[l] < arr[left]) l++;
            while (r > left && arr[r] >= arr[left]) r--;
            if (l < r) {
                swap(arr, l, r);
            }
        }
        if (arr[r] < arr[left]) {
            swap(arr, left, r);
            return r;
        } else {//left本就是这部分最小的
            return left;
        }
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    @Test
    public void s() {
        int[] ints = smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        System.out.println(Arrays.toString(ints));
    }
}
