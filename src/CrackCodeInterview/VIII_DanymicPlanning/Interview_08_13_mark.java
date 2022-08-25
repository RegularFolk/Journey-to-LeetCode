package CrackCodeInterview.VIII_DanymicPlanning;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LIS问题
 * 相关题目：LC_300_mark(medium),LC_354_mark(hard)
 * 动态规划: n^2
 * 动态规划+贪心+二分: nlogn
 */
public class Interview_08_13_mark {
    /*
     * 动态规划，类似于背包问题
     *
     * 法一思路:
     *  首先根据三维中的一维排序，对于box[0]-box[n-1],
     *  求出以每个box作为底的最大高度;在求box[i]的最大高度时，
     *  利用递归，求从box[i-1]开始每一个为底的最大高度，再加上box[i]的高度就是以box[i]为底的最大高度
     *
     * 提交超时，需要去重优化
     * */
    public int pileBox1(int[][] box) {
        Arrays.sort(box, Comparator.comparingInt(box2 -> box2[2]));
        int max = 0;
        for (int i = 0; i < box.length; i++) {
            max = Math.max(max, makeStack(box, i));
        }
        return max;
    }

    private int makeStack(int[][] box, int i) {
        int max = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (absoluteBigger(box[i], box[j])) {
                max = Math.max(max, makeStack(box, j));
            }
        }
        return max + box[i][2];
    }

    /*
     * 利用数组做散列表优化
     * */
    public int pileBox2(int[][] box) {
        Arrays.sort(box, Comparator.comparingInt(box2 -> box2[2]));
        int max = 0;
        int[] map = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            max = Math.max(max, makeStack1(box, i, map));
        }
        return max;
    }

    private int makeStack1(int[][] box, int i, int[] map) {
        if (map[i] > 0) {
            return map[i];
        }
        int max = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (absoluteBigger(box[i], box[j])) {
                max = Math.max(max, makeStack1(box, j, map));
            }
        }
        map[i] = max + box[i][2];
        return map[i];
    }

    /*
     * 另一种思路，先排序，最大高度为排序后的一个子序列
     * 利用dp求这个子序列
     * 更加简洁，时间复杂度实际上是一样的，都是O(n^2)
     * */
    public int pileBox3(int[][] box) {
        Arrays.sort(box, Comparator.comparingInt(box2 -> box2[2]));
        int max = 0;
        int[] dp = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (absoluteBigger(box[i], box[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean absoluteBigger(int[] a, int[] b) {
        return a[0] > b[0] && a[1] > b[1] && a[2] > b[2];
    }

}
