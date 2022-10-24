package Leet.Medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LC_128 {
    /*
     * 先扫描一次建立哈希表，之后基于哈希表分析
     * 每遍历到一个数，便递归查找小于其的数，一边查找一边置零避免重复计算，
     * 同时更新当前往前连续的个数
     * */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) == 0) {
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer e : set) {
            int v = map.getOrDefault(e, 0);
            if (v > 0) {
                v = v + analyse(map, e - 1);
                map.put(e, v);
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }

    private int analyse(Map<Integer, Integer> map, Integer key) {
        Integer value = map.getOrDefault(key, 0);
        if (value == 0) {
            return 0;
        } else {
            int ans = value + analyse(map, key - 1);
            map.put(key, 0);//置0避免重复计算
            return ans;
        }
    }

    @Test
    public void s() {
        int i = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
}
