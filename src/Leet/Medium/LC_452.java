package Leet.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_452 {
    /*
     * ÅÅÐò
     * */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else return Integer.compare(a[0], b[0]);
        });
        long ans = 0, left = (long) Integer.MIN_VALUE - 1;
        for (int[] point : points) {
            if ((long) point[0] > left) {
                ans++;
                left = point[1];
            } else {
                left = Math.min(left, point[1]);
            }
        }
        return (int) ans;
    }

    @Test
    public void x() {
        int minArrowShots = findMinArrowShots(new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}});
        System.out.println(minArrowShots);
    }
}
