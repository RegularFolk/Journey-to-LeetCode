package Medium;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC_6178 {
    /*
     * ����̰��,����������������
     * ����TreeMap���ҵ�һ��С�ڵ�ǰ��߽���ұ߽�
     * */
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();//�ұ߽�Ϊkey���м���
        for (int[] interval : intervals) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(interval[0] - 1);
            Integer curEdge = map.getOrDefault(interval[1], 0);
            if (entry != null && entry.getValue() > 0) {
                if (entry.getValue() == 1) map.remove(entry.getKey());
                else map.put(entry.getKey(), entry.getValue() - 1);
            }
            map.put(interval[1], curEdge + 1);
        }
        AtomicInteger ans = new AtomicInteger();
        map.forEach((k, v) -> ans.addAndGet(v));
        return ans.get();
    }

    @Test
    public void x() {
        int i = minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}});
        System.out.println(i);
    }
}
