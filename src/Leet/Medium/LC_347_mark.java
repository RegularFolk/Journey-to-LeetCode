package Leet.Medium;

import java.util.*;

public class LC_347_mark {
    /*
     * ���������硰ǰK����������K�����ȵ����⣬�����Գ��Զ�
     * ��Ϊ�Ѿ��С��ֲ����򡱵�����
     * ά��һ����СΪk��С���Ѻ�map��¼ÿ�����ֳ��ֵĴ���
     * ����ʽ���Ȱ�����map���꣬Ȼ�󲻶�����ѣ�
     * ���ѵĴ�С����kʱ���Ƴ��Ѷ�
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
