package LeetCode.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_1620 {
    /*
     * 数据量小，暴力遍历
     * */
    public int[] bestCoordinate(int[][] towers, int radius) {
        final int xMin = 0, yMin = 0, xMax = 50, yMAx = 50;
        int[] ans = null;
        int maxStrength = -1;
        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMAx; y++) {
                int strength = 0;
                for (int[] tower : towers) strength += getStrength(x, y, tower, radius);
                if (strength > maxStrength) {
                    ans = new int[]{x, y};
                    maxStrength = strength;
                }
            }
        }
        return ans;
    }

    private int getStrength(double x, double y, int[] tower, int radius) {
        double dis = Math.sqrt((x - tower[0]) * (x - tower[0]) + (y - tower[1]) * (y - tower[1]));
        if (dis > radius) return 0;
        else return (int) (tower[2] / (1 + dis));
    }

}
