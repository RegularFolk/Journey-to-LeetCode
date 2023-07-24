package LeetCode.Easy;

public class LC_70 {
    /*
     * ��¥��dp
     * �� dp[i] Ϊ���� i ��ķ���
     * �� dp[i] = dp[i-1] + dp[i-2]
     * ��������ֻ��ǰ�����йأ����Կ���ʹ�ù�������
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
