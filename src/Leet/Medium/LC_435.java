package Leet.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class LC_435 {
    /*
     * 贪心 按照右边界升序排列
     * 尽可能选择右边界小的，则可以尽可能容下更多的区间
     * */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int edge = Integer.MIN_VALUE, ans = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= edge) {
                edge = interval[1];
            } else ans++;
        }
        return ans;
    }
}
