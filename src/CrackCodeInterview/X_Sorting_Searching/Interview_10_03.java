package CrackCodeInterview.X_Sorting_Searching;

import org.junit.Test;

public class Interview_10_03 {
    /*
     * 关键在于找出分界点edge
     * */
    public int search(int[] arr, int target) {
        int edge = findEdge(arr, 0, arr.length - 1);
        if (target >= arr[0]) {
            return binFind(arr, 0, edge - 1, target);
        } else {
            return binFind(arr, edge, arr.length - 1, target);
        }
    }

    public int binFind(int[] arr, int l, int r, int tar) {
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] == tar) {
                ans = mid;
                r = mid - 1;
            } else if (arr[mid] > tar) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int findEdge(int[] arr, int l, int r) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[0]) {
                l = mid + 1;
            } else if (arr[mid] < arr[0]) {
                r = mid - 1;
            } else {
                return Math.max(findEdge(arr, l, mid - 1), findEdge(arr, mid + 1, r));
            }
        }
        return 0;
    }

    @Test
    public void s() {
        int search = search(new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1}, 2);
        System.out.println(search);
    }
}
