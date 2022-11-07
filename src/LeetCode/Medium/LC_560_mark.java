package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LC_560_mark {
    /*
     * 滑动窗口
     * 无法用滑动窗口，因为中间结果可以小于零，无法决定左指针移还是右指针移
     * 用哈希表记录前缀和(从0到每个节点的累加和)
     *
     *             新增的sum(从0累加至此下标，大于k)
     *  |____________|_______________________________________|
     *    required                    K
     *     用map查
     *
     * */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            int required = sum - k;
            Integer mapValue = map.getOrDefault(required, 0);
            ans += mapValue;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
