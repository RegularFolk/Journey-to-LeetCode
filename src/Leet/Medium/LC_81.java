package Leet.Medium;

import CrackCodeInterview.X_Sorting_Searching.Interview_10_03;

public class LC_81 {
    /*
    * 两次二分查找，同Interview_10_03
    * */
    public boolean search(int[] arr, int target) {
        int edge = findEdge(arr, arr.length - 1);
        if (edge == 0) {//没有翻转
            return binFind(arr, 0, arr.length - 1, target);
        } else if (target >= arr[0]) {
            return binFind(arr, 0, edge - 1, target);
        } else {
            return binFind(arr, edge, arr.length - 1, target);
        }
    }

    private boolean binFind(int[] arr, int l, int r, int tar) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] == tar) {
                return true;
            } else if (arr[mid] > tar) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    private int findEdge(int[] arr, int r) {
        return new Interview_10_03().findEdge(arr, 0, r);
    }
}
