package LeetCode.Easy;

public class LC_1472 {
    /*
    * ģ��
    * */
    public int countBalls(int lowLimit, int highLimit) {
        int[] map = new int[50]; //������Χ�ڸ�λ��֮�Ͳ�����50
        int max = 0;
        while (lowLimit <= highLimit) {
            int countDigit = countDigit(lowLimit);
            map[countDigit]++;
            max = Math.max(max, map[countDigit]);
            lowLimit++;
        }
        return max;
    }

    private int countDigit(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}
