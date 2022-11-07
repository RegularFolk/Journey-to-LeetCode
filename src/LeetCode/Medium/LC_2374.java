package LeetCode.Medium;

import org.junit.Test;

public class LC_2374 {
    @Test
    public void t() {
        int i = edgeScore(new int[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        System.out.println("i = " + i);
    }

    public int edgeScore(int[] edges) { //找出一个点被加起来值最大的指着
        long[] scores = new long[edges.length]; //加起来会很大，超过最大int
        for (int i = 0; i < edges.length; i++) {
            scores[edges[i]] += i;
        }
        int ans = -1;
        long max = -1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                ans = i;
                max = scores[i];
            }
        }
        return ans;
    }
}
