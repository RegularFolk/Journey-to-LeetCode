package Leet.Medium;

import java.util.*;

//通过了 32/35 ，未完全解决
public class LC_497 {

    int totalSquare;
    TreeMap<Integer, Integer> countSquares = new TreeMap<>();
    int[][] copy;

    public LC_497(int[][] rects) {
        copy = rects;
        int length = rects.length;
        for (int i = 0; i < length; i++) {
            int square = (rects[i][2] - rects[i][0]) * (rects[i][3] - rects[i][1]);
            totalSquare += square;
            countSquares.put(totalSquare, i);
        }
    }

    public int[] pick() {
        Random r = new Random();
        int square = r.nextInt(totalSquare) + 1;
        Integer index = countSquares.get(countSquares.ceilingKey(square));
        int[] ints = copy[index];
        return new int[]{r.nextInt(ints[2] - ints[0] + 1) + ints[0], r.nextInt(ints[3] - ints[1] + 1) + ints[1]};
    }
}

//题解
class Solution {
    int[][] rs;
    int[] sum;
    int n;
    Random random = new Random();

    public Solution(int[][] rects) {
        rs = rects;
        n = rs.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1] + 1);
    }

    public int[] pick() {
        int val = random.nextInt(sum[n]) + 1;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= val) r = mid;
            else l = mid + 1;
        }
        int[] cur = rs[r - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }
}


 /*int lenX, lenY, baseX, baseY;
    int[][] gapsX, gapsY;

    public LC_497(int[][] rects) {
        int length = rects.length;
        gapsX = new int[rects.length - 1][2];
        gapsY = new int[rects.length - 1][2];
        int[][] cloneX = rects.clone();
        int[][] cloneY = rects.clone();
        Arrays.sort(cloneX, Comparator.comparingInt(p -> p[0]));//根据X升序
        Arrays.sort(cloneY, Comparator.comparingInt(p -> p[1]));//根据Y升序
        baseX = cloneX[0][0];
        baseY = cloneY[0][1];
        for (int i = 0; i < length - 1; i++) {
            lenX += cloneX[i][2] - cloneX[i][0];
            lenY += cloneY[i][2] - cloneY[i][0];
            gapsX[i][0] = lenX;
            gapsX[i][1] = cloneX[i + 1][0] - cloneX[i][2];
            gapsY[i][0] = lenY;
            gapsY[i][1] = cloneY[i + 1][1] - cloneY[i][3];
        }
        lenX += cloneX[length - 1][2] - cloneX[length - 1][0];
        lenY += cloneY[length - 1][2] - cloneY[length - 1][0];
    }

    public int[] pick() {
        Random r = new Random();
        int x = r.nextInt(lenX + 1);
        int y = r.nextInt(lenY + 1);
        for (int[] ints : gapsX) {
            if (x > ints[0]) {
                x += ints[1];
            } else {
                break;
            }
        }
        for (int[] ints : gapsY) {
            if (y > ints[0]) {
                y += ints[1];
            } else {
                break;
            }
        }
        return new int[]{x + baseX, y + baseY};
    }*/
