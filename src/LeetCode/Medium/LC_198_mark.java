package LeetCode.Medium;

public class LC_198_mark {
    /*
     * ��̬�滮
     * ʱ�临�Ӷ�n^2
     * dp[i]��ʾ��nums[i]��β�����ֵ
     * */
    public int rob(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
     * �Ż����Ʒ���,��ÿһ�����ӣ���͵���߲�͵����״̬
     * dp[i] = max(dp[i]+dp[i-2],dp[i-1])
     * �������Ż��ռ䣬ֻ�豣��dp[i-1]��dp[i-2]
     * */
    public int rob1(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}

class LC_198_redo {

    /*
     * ��̬�滮
     * dp[i] ��ʾ͵�� i ��ʱ����Ǯ
     * ���� dp[i] = max(dp[i-1], dp[i-2] + val[i])
     * ǰ���ǲ�͵��ǰ��ң�������͵��ǰ���
     * ֻ��ǰ����ֵ�йأ�����ʹ�ù��������Ż��ռ临�Ӷ�
     * ע���ʼ��
     *
     * ��һ�����ײ����ɻ�ĵ㣬����dp[i] �����ܲ������ֵʱ�±�Ϊi�ǲ�ȡ����
     * ��ô����dp[i+1]�����ǾͿ���ѡ��dp[i] + nums[i+1]��
     * �������������dp[i] == dp[i-1],�����ĵ��ƹ�ʽ�Ǽ��ݵ�
     * */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int a = nums[0], b = Math.max(nums[0], nums[1]), c = nums[2];
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }
}
