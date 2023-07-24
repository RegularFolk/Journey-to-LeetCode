package LeetCode.Easy;

public class LC_70 {
    /*
     * 爬楼梯dp
     * 设 dp[i] 为爬到 i 层的方法
     * 则 dp[i] = dp[i-1] + dp[i-2]
     * 并且由于只和前两项有关，所以可以使用滚动数组
     * */
    public int climbStairs(int n) {
        if (n < 3) {
            return n == 1 ? 1 : 2;
        }
        int i_1, i_2 = 2, i_3 = 3;
        n -= 3;
        while (n > 0) {
            i_1 = i_2;
            i_2 = i_3;
            i_3 = i_1 + i_2;
            n--;
        }
        return i_3;
    }

}
