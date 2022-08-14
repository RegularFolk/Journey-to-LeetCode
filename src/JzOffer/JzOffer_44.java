package JzOffer;

public class JzOffer_44 {
    public int findNthDigit(int n) {
        int len = 1;
        while (getCnt(len) <= n) {
            n -= getCnt(len);
            len++;
        }//锁定n在哪个len的范围内
        long start = (long) Math.pow(10, len - 1);
        start += n / len;
        n -= n / len * len; //n减掉n整除len后乘len，获得n在目标数中的偏移量
        if (n == 0) { //刚好是末尾
            return (int) (start - 1) % 10;
        }
        else {
            return String.valueOf(start).toCharArray()[n - 1] - '0';
        }
    }

    private long getCnt(int len) {  //所有长为len的数加起来的总长度
        return (long) (Math.pow(10, len) - Math.pow(10, len - 1)) * len;
    }
}
