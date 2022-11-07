package LeetCode.Medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LC_658 {
    /*
    * 二分加双指针
    * 时间复杂度logn+k
    * */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closest = findClosest(arr, x);
        LinkedList<Integer> ans = new LinkedList<>();
        if (closest == -1) {//所有元素小于x
            for (int i = arr.length - k; i < arr.length; i++) {
                ans.add(arr[i]);
            }
        } else if (closest == 0) {
            for (int i = 0; i < k; i++) {
                ans.add(arr[i]);
            }
        } else {
            closest = findMin(arr, closest, x);
            ans.add(arr[closest]);
            for (int i = 1, l = closest - 1, r = closest + 1; i < k; i++) {
                if (r == arr.length || (l >= 0 && Math.abs(arr[l] - x) <= Math.abs(arr[r] - x))) {
                    ans.addFirst(arr[l--]);
                } else {
                    ans.addLast(arr[r++]);
                }
            }
        }
        return ans;
    }

    private int findMin(int[] arr, int closest, int x) {
        if (closest == 0) {
            return closest;
        }
        int r = Math.abs(arr[closest] - x), l = Math.abs(arr[closest - 1] - x);
        if (r < l) {
            return closest;
        } else {
            return findMin(arr, closest - 1, x);
        }
    }

    /*
     * 找大于等于x的最小值，如果都小于x就返回-1
     * */
    private int findClosest(int[] arr, int x) {
        int l = 0, r = arr.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= x) {
                pos = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }

    @Test
    public void s() {
        List<Integer> closestElements = findClosestElements(new int[]{3, 5, 8, 10}, 2, 15);
        System.out.println("closestElements.size() = " + closestElements.size());
        for (Integer closestElement : closestElements) {
            System.out.println("closestElement = " + closestElement);
        }
    }
}
