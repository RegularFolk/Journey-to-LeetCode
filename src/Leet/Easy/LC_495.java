package Leet.Easy;

public class LC_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = duration;
        int len = timeSeries.length;
        for (int i = 1; i < len; i++) {
            ans += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return ans;
    }
}
