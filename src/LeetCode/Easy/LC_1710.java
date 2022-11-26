package LeetCode.Easy;

import java.util.Arrays;
import java.util.Comparator;

public class LC_1710 {
    /*
     * ÅÅÐò
     * */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> (-1) * a[1]));
        int ans = 0, used = 0;
        for (int[] boxType : boxTypes) {
            int add = Math.min(boxType[0], truckSize - used);
            ans += boxType[1] * add;
            used += add;
            if (used == truckSize) return ans;
        }
        return ans;
    }
}
