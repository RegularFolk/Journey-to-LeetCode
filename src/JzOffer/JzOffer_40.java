package JzOffer;

import org.junit.Test;

import java.util.Arrays;

public class JzOffer_40 {
    @Test
    public void test() {
        int[] ints = getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8);
        for (int i : ints) {
            System.out.println("i = " + i);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) { //傻瓜法 复杂度nk，实测巨慢无比
        if (k == 0) {
            return new int[0];
        }
        int[] window = new int[k];
        int count = 0;
        for (int i : arr) {
            if (count < k) {
                window[count++] = i;
            } else {
                int n = i;
                for (int j = 0; j < window.length; j++) {
                    if (window[j] > n) {
                        int temp = window[j];
                        window[j] = n;
                        n = temp;
                    }
                }
            }
        }
        return window;
    }

    public int[] getLeastNumbers2(int[] arr, int k) { //放弃治疗 复杂度nlogn
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public int[] getLeastNumbers1(int[] arr, int k) { //通法，用O(n)时间复杂度找出第k小的值
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {   //同时结合了快排和二分
            int index = partition(arr, left, right);
            if (index == k - 1) {
                break;
            } else if (index < k - 1) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int partition(int[] arr, int left, int right) { //相当于快速排序的一半，比left小的全部在左边，但是小的部分不排序
        int pivot = arr[left];
        int index = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, ++index);
            }
        }
        swap(arr, left, index);
        return index;
    }

    public void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public int[] getLeastNumbers3(int[] arr, int k) { //数据范围有限，利用计数排序
        if (k == 0) {
            return new int[0];
        }
        int[] ints = new int[10001], ans = new int[k];
        int count = 0;
        for (int i : arr) {
            ints[i]++;
        }
        for (int i = 0; i < ints.length; i++) {
            while (ints[i]-- > 0 && count < k) {
                ans[count++] = i;
            }
            if (count == k) {
                break;
            }
        }
        return ans;
    }
}
