package CrackCodeInterview;

import org.junit.Test;

public class Interview_05_01 {
    @Test
    public void t() {
        int i = -1 << 5;
        System.out.println("i = " + i);
        int i1 = insertBits(1024, 19, 2, 6);
        System.out.println("i1 = " + i1);
    }

    /*
     * 1.将N中从j到i之间的位清零
     * 2.对M进行移位，与j和i之间的位对齐
     * 3.合并M与N
     *  需要换成long否则提交不通过
     * */
    public int insertBits(int N, int M, int i, int j) {
        long left = (long) (~0) << (j + 1);//111100000
        long right = ((1L << i) - 1);//00000011
        long mask = left | right;//1111000011
        return (int) ((N & mask) | (M << i));
    }
}
