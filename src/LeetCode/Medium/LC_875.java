package LeetCode.Medium;

import java.util.Arrays;

public class LC_875 {
    /**
     * 个人思路，未完成
     * 首先根据n和h的关系确定k的上界和下界
     * 在界内利用二分查找找出最小符合条件的k
     * 界内查找时，想象切各个高度不同的柱状图，维护切过的总高度height和还没切完的最矮柱的下标min
     * 根据切完时所用hour是否等于h判断是否有效
     * 应该是比官方答案要高效的，但是代码实现复杂很多很多
     */
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length, kMin = 0, kMax = (piles[n - 1] / (h - n + 1)) + 1, ans = 0;
        if (h == n) {  //根据h和n的关系确定kMin的下界
            return piles[n - 1];
        } else if (h <= 2 * n - 1) {
            kMin = piles[2 * n - 1 - h];
        } else {
            kMin = 1;
        }
        while (kMax > kMin) {//此处有误
            ans = (kMin + kMax) / 2;
            boolean qualified = qualified(ans, piles, h);
            if (qualified) {
                kMax = ans;
            } else {
                kMin = ans + 1;
            }
        }
        return ans;
    }

    private boolean qualified(int k, int[] piles, int h) {
        int min = 0, height = 0, hour = h, round = 1, length = piles.length;
        while (height < piles[length - 1] && hour > 0) {
            height = round++ * k;
            int newMin = min;
            for (int i = min; i < length; i++) {
                if (piles[i] >= height) {
                    newMin = i;
                    break;
                }
            }
            hour -= length - min;
            min = newMin;
        }
        return height >= piles[length - 1] && hour == 0;
    }

    public int minEatingSpeed2(int[] piles, int h) { //cv题解
        int l = 0, r = (int) 1e9;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(piles, mid, h)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    boolean check(int[] p, int k, int h) {
        int ans = 0;
        for (int x : p) ans += Math.ceil(x * 1.0 / k);
        return ans <= h;
    }
}
