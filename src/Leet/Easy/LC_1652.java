package Leet.Easy;

import java.util.Arrays;

public class LC_1652 {
    /*
     * 循环数组+滑动窗口
     * */
    public int[] decrypt(int[] code, int k) {
        if (k == 0) Arrays.fill(code, 0);
        else {
            int[] circle = new int[code.length << 1];
            System.arraycopy(code, 0, circle, 0, code.length);
            System.arraycopy(code, 0, circle, code.length, code.length);
            int sum = 0;
            if (k > 0) {
                for (int i = 1; i <= k; i++) {
                    sum += circle[i];
                }
                for (int i = 0; i < code.length; i++) {
                    code[i] = sum;
                    sum -= circle[i + 1];
                    sum += circle[i + k + 1];
                }
            } else {
                k *= -1;
                for (int i = code.length - 1; i >= code.length - k; i--) {
                    sum += circle[i];
                }
                for (int i = 0; i < code.length; i++) {
                    code[i] = sum;
                    sum += circle[code.length + i];
                    sum -= circle[code.length + i - k];
                }
            }
        }
        return code;
    }
}
