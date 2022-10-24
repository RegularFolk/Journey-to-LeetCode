package Leet.Easy;

public class LC_338 {
    /*
     * ���һ������2������������1��������1������������������С��������2����������1�ĸ�����1
     * ��̬�滮
     * ʱ�临�Ӷ�n
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
