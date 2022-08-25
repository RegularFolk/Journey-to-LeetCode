package Medium;

public class LC_70 {
    /*
     * 动态规划入门题
     * dp[i]=dp[i-2]+dp[i-1]
     * 斐波那契数列
     * */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int n1 = 1, n2 = 2, ans = 0;
        while (n-- > 2) {
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
        }
        return ans;
    }
}
