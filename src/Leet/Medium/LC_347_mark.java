package Leet.Medium;

import java.util.*;

public class LC_347_mark {
    /*
     * 当遇到例如“前K个”、“第K个”等的问题，都可以尝试堆
     * 因为堆具有“局部排序”的属性
     * 维护一个大小为k的小根堆和map记录每个数字出现的次数
     * 处理方式是先把整个map建完，然后不断塞入堆，
     * 当堆的大小超过k时，移除堆顶
     * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> topK = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            topK.add(entry);
            if (topK.size() > k) {
                topK.poll();
            }
        }
        int[] ans = new int[k];
        int count = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = topK.iterator();
        while (count < k) {
            ans[count++] = iterator.next().getKey();
        }
        return ans;
    }
}
