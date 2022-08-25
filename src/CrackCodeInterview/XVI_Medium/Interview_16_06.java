package CrackCodeInterview.XVI_Medium;

import java.util.Arrays;

public class Interview_16_06 {
    /*
     * 排序加双指针,逐渐逼近
     * */
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int cur1 = 0, cur2 = 0;
        long ans = Long.MAX_VALUE;
        while (cur1 < a.length && cur2 < b.length) {
            ans = Math.min(ans, Math.abs((long) (a[cur1] - b[cur2])));
            if (a[cur1] >= b[cur2]) {
                cur2++;
            } else {
                cur1++;
            }
        }
        if (cur1 < a.length - 1) {
            ans = Math.min(ans, Math.abs((long) (a[cur1 + 1] - b[cur2 - 1])));
        } else if (cur2 < b.length - 1) {
            ans = Math.min(ans, Math.abs((long) (a[cur1 - 1] - b[cur2 + 1])));
        }
        return (int) ans;
    }
}
