package Leet.Easy;

import java.util.Arrays;

public class LC_1051 {
    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        int ans = 0;
        Arrays.sort(clone);
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }
}
