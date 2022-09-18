package Medium;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC_6178 {
    /*
     * 区间贪心,根据左右区间排序
     * 利用TreeMap查找第一个小于当前左边界的右边界
     * */
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();//右边界为key的有几个
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
