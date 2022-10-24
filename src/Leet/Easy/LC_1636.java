package Leet.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LC_1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue().compareTo(b.getValue()));
        int[] ans = new int[nums.length];
        int cursor = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            Integer value = entry.getValue();
            while (value-- > 0) {
                ans[cursor++] = entry.getKey();
            }
        }
        return ans;
    }
}
