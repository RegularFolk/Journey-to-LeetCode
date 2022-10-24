package Leet.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class LC_435 {
    /*
     * ̰�� �����ұ߽���������
     * ������ѡ���ұ߽�С�ģ�����Ծ��������¸��������
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
