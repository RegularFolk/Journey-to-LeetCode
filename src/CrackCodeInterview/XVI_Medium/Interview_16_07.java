package CrackCodeInterview.XVI_Medium;

import org.junit.Test;

public class Interview_16_07 {
    /*
    * 利用异常
    * */
    public int maximum(int a, int b) {
        try {
            int[] x = new int[Long.toString((long) a - (long) b).charAt(0) - '0'];
            return a;
        } catch (Exception e) {
            return b;
        }
    }

    @Test
    public void s() {
        System.out.println(Integer.valueOf(Integer.toString(-1).charAt(0)));
        System.out.println(Long.toString((long) Integer.MAX_VALUE - (long) Integer.MIN_VALUE).charAt(0) - '0');
    }
}
