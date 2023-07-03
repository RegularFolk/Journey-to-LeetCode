package JzOffer.JzOffer_II;

import java.util.*;

public class JzOfferII_060 {
    /*
     * 堆的简单应用
     * */
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<AbstractMap.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(Comparator.comparingInt(AbstractMap.Entry::getValue));
        AbstractMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        map.entrySet().forEach(e -> {
            heap.add(e);
            if (heap.size() > k) heap.poll();
        });
        int[] ans = new int[k];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : heap) ans[count++] = entry.getKey();
        return ans;
    }
}
