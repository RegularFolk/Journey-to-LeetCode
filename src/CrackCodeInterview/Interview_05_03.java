package CrackCodeInterview;

public class Interview_05_03 {
    /*
     * 无需转为字符串处理
     * */
    public int reverseBits(int num) {
        if (num == -1) {
            return 32;
        }
        int cur = 0, prev = 0, max = 1;//至少有一个1
        while (num != 0) {
            if ((num & 1) == 1) {
                cur++;
            } else {
                prev = (num & 2) == 0 ? 0 : cur;
                cur = 0;
            }
            max = Math.max(prev + cur + 1, max);//加1是算上了那个0
            num >>>= 1;//无符号右移，高位填1
        }
        return max;
    }
}
