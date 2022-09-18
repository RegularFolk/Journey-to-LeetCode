package Medium;


public class LC_45 {
    /*
     * ��̬�滮
     * dp[i]��ʾ����i������ٲ���
     * ע���֦
     * ʵ���Ϻ�̰�ĵ�˼·��һ����
     * */
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length && dp[nums.length - 1] == 0; i++) {
            for (int j = Math.min(nums.length - 1, nums[i] + i); j > i && dp[j] == 0; j--) {
                dp[j] = dp[i] + 1;
            }
        }
        return dp[dp.length - 1];
    }
}
