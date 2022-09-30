package Medium;

import org.junit.Test;

public class LC_6189 {
    /*
     * ��̬�滮
     * dp[i][0]��ʾ��nums[i]��Ϊ��β�����������
     * dp[i][1]��ʾ�����鳤��
     * */
    public int longestSubarray(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int max = nums[0], len = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & dp[i - 1][0]) >= nums[i]) {
                dp[i][0] = nums[i] & dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
                max = Math.max(max, dp[i][0]);
            }
            if (dp[i][0] == max) len = Math.max(len, dp[i][1]);
            else if (dp[i][0] > max) len = dp[i][1];
        }
        return len;
    }

    @Test
    public void x() {
        int i = longestSubarray(new int[]{1, 2, 3, 3, 2, 2});
        System.out.println("i = " + i);
    }
}
