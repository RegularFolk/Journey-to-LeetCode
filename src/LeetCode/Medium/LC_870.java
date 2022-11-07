package LeetCode.Medium;

import java.util.Map;
import java.util.TreeMap;

public class LC_870 {
    /*
    * 利用treeMap，时间复杂度nlogn
    * 慢，原因是复杂度常数过大
    * */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : nums1) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(nums2[i] + 1);
            if (ceilingEntry == null) {
                Map.Entry<Integer, Integer> firstEntry = treeMap.firstEntry();
                ans[i] = firstEntry.getKey();
                if (firstEntry.getValue() == 1) treeMap.remove(firstEntry.getKey());
                else treeMap.put(firstEntry.getKey(),firstEntry.getValue() - 1 );
            } else {
                ans[i] = ceilingEntry.getKey();
                if (ceilingEntry.getValue() == 1) treeMap.remove(ceilingEntry.getKey());
                else treeMap.put(ceilingEntry.getKey(),ceilingEntry.getValue() - 1 );
            }
        }
        return ans;
    }
}
