package Leet.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_646 {
    /*
     * ��άLIS
     * ����̰�ĺͶ��ֵĶ�̬�滮
     * dp[i]��ʾ�Գ���Ϊi����Сβpair
     * */
    public int findLongestChain(int[][] pairs) {
        int max = 1;
        int[] dp = new int[pairs.length + 1];
        Arrays.sort(pairs, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > pairs[dp[max]][1]) {
                dp[++max] = i;
            } else {//��С�ڸ�pair�����pair���ڵĳ���
                int l = 1, r = max, len = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (pairs[dp[mid]][1] < pairs[i][0]) {
                        len = mid;
                        l = mid + 1;

                    } else r = mid - 1;
                }
                if (pairs[i][1] < pairs[dp[len + 1]][1]) {
                    dp[len + 1] = i;
                }
            }
        }
        return max;
    }

    @Test
    public void x() {
        int longestChain = findLongestChain(new int[][]{{9, 10}, {-4, 9}, {-5, 6}, {-5, 9}, {8, 9}});
        System.out.println(longestChain);
    }
}
