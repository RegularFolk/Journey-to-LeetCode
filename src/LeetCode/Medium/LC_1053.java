package LeetCode.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_1053 {
    /*
     * 先从右往前找到第一个降序的位置
     * 这个位置往后找一个比其小的最大值交换即可
     * */
    public int[] prevPermOpt1(int[] arr) {
        int l = arr.length - 2;
        while (l >= 0 && arr[l] <= arr[l + 1]) {
            l--;
        }
        if (l == -1) return arr;
        int r = l + 1, max = arr[r];
        for (int i = r; i < arr.length; i++) {
            if (arr[i] < arr[l] && arr[i] > max) {
                r = i;
                max = arr[i];
            }
        }
        if (max == arr[l]) return arr;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return arr;
    }
}
