package Leet.Medium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC_532 {
    public int findPairs(int[] nums, int k) { //二分查找,利用set记录已经使用过的数
        int length = nums.length, ans = 0;
        if (length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < length - 1; i++) {
            if (!used.contains(nums[i]) && binarySearch(i + 1, length - 1, nums, nums[i] + k)) {
                ans++;
                used.add(nums[i]);
            }
        }
        return ans;
    }

    private boolean binarySearch(int left, int right, int[] nums, int tar) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > tar) {
                right = mid - 1;
            } else if (nums[mid] < tar) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int findPairs1(int[] nums, int k) {  //哈希表,k为0时特殊处理
        if (nums.length == 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger ans = new AtomicInteger();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (k == 0) {
            map.forEach((key, v) -> {
                if (map.get(key) > 1) {
                    ans.addAndGet(1);
                }
            });
        } else {
            map.forEach((key, v) -> {
                if (map.containsKey(key + k)) {
                    ans.addAndGet(1);
                }
            });
        }
        return ans.get();
    }
}
