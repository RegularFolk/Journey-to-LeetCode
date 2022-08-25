package CrackCodeInterview.V_BitOperation;

import org.junit.Test;

public class Interview_05_06 {
    /*
     * 求异或之后1的个数
     * */
    public int convertInteger(int A, int B) {
        int c = A ^ B;//c如果用long会在负数出错
        return countOne(c);
    }

    private int countOne(int c) {
        int ans = 0;
        while (c != 0) {
            ans++;
            c &= c - 1;
        }
        return ans;
    }

    /*
     * 将c >>>= 1 变为 c = c & (c - 1)
     * 意为每次消掉最右边的一个1
     * */
    public int convertInteger2(int A, int B) {
        int count = 0;
        for (int i = A ^ B; i != 0; i &= i - 1) {
            count++;
        }
        return count;
    }

    @Test
    public void t() {
        int i = convertInteger(826966453, -729934991);
        System.out.println("i = " + i);
    }
}
