package Leet.Medium;

public class LC_152 {
    /*
     * ά������ֵ��һ��Ϊ���ֵ��һ��Ϊ��Сֵ
     * ��������
     * */
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
