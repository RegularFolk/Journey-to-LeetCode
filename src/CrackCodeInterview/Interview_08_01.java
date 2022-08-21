package CrackCodeInterview;

public class Interview_08_01 {
    /*
     * 动态规划经典题
     * 推到思路:跳到每一层时，有三种情况，
     * 第一种是最后一步跳一层，则此前有f(n-1)种，
     * 第二种是最后一步跳二层，则此前有f(n-2)种，
     * 第三种是最后一步跳三层，则此前有f(n-3)种，
     * 所以状态转移方程为:
     *   f(n)=f(n-1)+f(n-2)+f(n-3)
     *
     * 注意溢出，在再每个加法之后取模
     * */
    public int waysToStep(int n) {
        int n1 = 0, n2 = 0, n3 = 1, n4 = 0;
        while (n-- > 0) {
            n4 = ((n1 + n2) % 1000000007 + n3) % 1000000007;
            n1 = n2;
            n2 = n3;
            n3 = n4;
        }
        return n4;
    }
}
