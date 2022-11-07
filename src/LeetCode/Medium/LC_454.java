package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LC_454 {
    /*
     * 用哈希表存储nums1和nums2相加的和出现的次数
     * 再对nums3和nums4遍历分析
     * 小技巧
     * 将四个数组分成两两处理，时间复杂度从n^4降到了2n^2
     * */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Long, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put((long) (n1 + n2), map.getOrDefault((long) (n1 + n2), 0) + 1);
            }
        }
        int ans = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                ans += map.getOrDefault((long) ((n3 + n4) * -1), 0);
            }
        }
        return ans;
    }
}
