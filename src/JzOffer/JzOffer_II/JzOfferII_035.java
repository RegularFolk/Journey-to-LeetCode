package JzOffer.JzOffer_II;

import java.util.Collections;
import java.util.List;

public class JzOfferII_035 {
    //排序后比较相邻和头尾
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) return 0;
        Collections.sort(timePoints);
        int ans = diff(timePoints.get(timePoints.size() - 1), timePoints.get(0)) + 24 * 60;
        String last = null;
        for (String timePoint : timePoints) {
            if (last != null) ans = Math.min(ans, diff(last, timePoint));
            last = timePoint;
        }
        return ans;
    }

    private int diff(String t1, String t2) {
        int hourDiff = Integer.parseInt(t2.substring(0, 2)) - Integer.parseInt(t1.substring(0, 2));
        int minDiff = Integer.parseInt(t2.substring(3)) - Integer.parseInt(t1.substring(3));
        return hourDiff * 60 + minDiff;
    }
}
