package LeetCode.Easy;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1619 {
    /*
     * 堆的应用
     * 大根堆存最小的k个，小根堆存最大的k个
     * 时间复杂度nlogk , k = n/20
     * 数据量太小体现不出优势
     * */
    public double trimMean1(int[] arr) {
        int sum = 0, k = arr.length / 20, bigSum = 0, smallSum = 0;
        PriorityQueue<Integer> big = new PriorityQueue<>(Comparator.comparingInt(a -> -1 * a)), small = new PriorityQueue<>();
        for (int i : arr) {
            if (big.isEmpty() || big.size() < k || i < big.peek()) {
                big.add(i);
                bigSum += i;
                if (big.size() > k) bigSum -= big.poll();
            }
            if (small.isEmpty() || small.size() < k || i > small.peek()) {
                small.add(i);
                smallSum += i;
                if (small.size() > k) smallSum -= small.poll();
            }
            sum += i;
        }
        return (double) (sum - bigSum - smallSum) / (arr.length - k - k);
    }

    /*
     * 利用快速选择，时间复杂度n
     * 大炮打蚊子
     * */
    public double trimMean2(int[] arr) {
        int k = arr.length / 20, sum = 0;
        partition(arr, 0, arr.length - 1, arr.length - k - 1);
        partition(arr, 0, arr.length - 1, k - 1);
        for (int i = k; i < arr.length - k; i++) {
            sum += arr[i];
        }
        return (double) sum / (arr.length - k - k);
    }

    private void partition(int[] arr, int left, int right, int rank) {
        if (left >= right) return;
        int l = left + 1, r = right, com = left;
        while (l < r) {
            while (l < right && arr[l] < arr[left]) l++;
            while (r > left && arr[r] >= arr[left]) r--;
            if (l < r) swap(arr, l, r);
        }
        if (arr[r] < arr[left]) {
            swap(arr, r, left);
            com = r;
        }
        if (com < rank) partition(arr, com + 1, right, rank);
        else if (r > rank) partition(arr, left, com - 1, rank);
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    @Test
    public void x() {
        double v = trimMean2(new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0});
        System.out.println(v);
    }
}
