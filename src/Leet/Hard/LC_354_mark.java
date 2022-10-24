package Leet.Hard;

import java.util.Arrays;
import java.util.Comparator;

public class LC_354_mark {
    /*
     * 动态规划 dp[i]代表第i个信封最多可以容纳的信封
     * 时间复杂度O(n^2)
     * 同hard-300和Interview_08_13
     *
     * 无情超时，需要优化
     * n^2时间复杂度一般适用于10^4以下的数据量
     * */
    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        int max = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
     * 参考LC_300，通过贪心和二分进行优化
     * 二维LIS问题
     * 排序时按照长度递增，同长则按照宽度递减(使同类的信封按照大到小排序，遇到下一类时最后的是同类最小信封，尽可能让之后信封可以套上) <----关键
     * dp[i]代表层数为i的最小信封，
     *  若envelope[i]>dp[max],则dp[++max]=envelope[i]
     *  否则，找到第一个小于envelope[i]的envelope[k],envelope[k+1]=envelope[i]
     * */
    public int maxEnvelopes2(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int max = 1;
        int[] dp = new int[envelopes.length + 1];
        for (int i = 0; i < envelopes.length; i++) {
            if (canContain(envelopes[i], envelopes[dp[max]])) {
                dp[++max] = i;
            } else {
                int l = 1, r = max, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (canContain(envelopes[i], envelopes[dp[mid]])) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[pos + 1] = i;
            }
        }
        return max;
    }

    private boolean canContain(int[] a, int[] b) {
        return a[0] > b[0] && a[1] > b[1];
    }
}
