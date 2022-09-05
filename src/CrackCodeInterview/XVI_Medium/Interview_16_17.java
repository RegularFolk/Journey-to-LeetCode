package CrackCodeInterview.XVI_Medium;

public class Interview_16_17 {
    /*
    * ���ھ������Ŀ��̰�ķ�
    * */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            if (sum < 0) sum = 0;
        }
        return ans;
    }
}
