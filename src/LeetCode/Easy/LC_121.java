package LeetCode.Easy;

public class LC_121 {
    /*
    * �Ӻ���ǰ������ά�����ֵ����ÿ����������ֵ������֮ǰ���ȡ���ֵ
    * */
    public int maxProfit(int[] prices) {
        int max = 0, highest = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            highest = Math.max(highest, prices[i]);
            max = Math.max(max, highest - prices[i]);
        }
        return max;
    }
}
