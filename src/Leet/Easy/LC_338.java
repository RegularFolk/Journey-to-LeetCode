package Leet.Easy;

public class LC_338 {
    /*
     * 如果一个数是2的整次数，则1的数量是1，否则就是这个数减掉小于它最大的2的整次数的1的个数加1
     * 动态规划
     * 时间复杂度n
     * */
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        } else if (n == 1) {
            return new int[]{0, 1};
        }
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        int tool = 2;
        for (int i = 2; i <= n; i++) {
            if (i == tool) {
                ans[i] = 1;
            } else if (i == tool << 1) {
                ans[i] = 1;
                tool <<= 1;
            } else {
                ans[i] = 1 + ans[i - tool];
            }
        }
        return ans;
    }
}
