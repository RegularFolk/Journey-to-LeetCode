package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
模拟
哈希
排序+二分(但是所求是下标，排序后会丢失下标)
*/

public class LC_1 {
    public static void main(String[] args) {
        int target;
        int n;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10000];
        int[] ans = new int[2];
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        target = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(ans[0] + " , " + ans[1]);
    }

    public static int[] twoSum(int[] numbs, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbs.length);
        for (int i = 0; i < numbs.length; i++) {
            if (!map.containsKey(target - numbs[i])) {
                map.put(numbs[i], i);
            } else {
                return new int[]{i, map.get(target - numbs[i])};
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int right = binarySearch(nums, i + 1, length, target - nums[i]);
            if (right != -1) {
                return new int[]{i, right};
            }
        }
        throw new RuntimeException();
    }

    private int binarySearch(int[] nums, int left, int right, int tar) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > tar) {
                right = mid - 1;
            } else if (nums[mid] < tar) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
