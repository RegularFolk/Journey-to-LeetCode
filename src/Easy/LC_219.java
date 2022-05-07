package Easy;

import java.util.HashSet;
import java.util.Set;

public class LC_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();  //滑动窗口
        int len = Math.min(nums.length - 1, k);
        for (int i = 0; i <= len; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        for (int right = len + 1; right < nums.length; right++) {
            int left = right - len;
            set.remove(nums[left - 1]);
            if (set.contains(nums[right])) {
                return true;
            } else {
                set.add(nums[right]);
            }
        }
        return false;
    }
}
