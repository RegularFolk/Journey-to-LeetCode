package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.Arrays;

public class JzOfferII_074 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1];
        });
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1), cur = intervals[i];
            if (cur[0] == last[1]) last[1] = cur[1];
            else if (cur[0] >= last[0] && cur[0] <= last[1] && cur[1] > last[1]) last[1] = cur[1];
            else if (cur[0] > last[1]) list.add(cur);
        }
        return list.toArray(int[][]::new);
    }
}
