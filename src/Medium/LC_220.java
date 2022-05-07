package Medium;

import java.util.TreeSet;

public class LC_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();  //滑动窗口加TreeSet
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Long nu = (long) nums[i];
            Long left = treeSet.floor(nu);
            Long right = treeSet.ceiling(nu);
            if ((left != null && nu - left <= t) || (right != null && right - nu <= t)) {
                return true;
            }
            treeSet.add(nu);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
