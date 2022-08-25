package CrackCodeInterview.V_BitOperation;

public class Interview_05_07 {
    /*
     * 逐位翻转
     * */
    public int exchangeBits1(int num) {
        int count = 0;
        while (count < 32) {
            int countV = get(num, count), count1V = get(num, count + 1);
            if (countV != count1V) {
                if (countV == 1) {
                    num &= ~(1 << count);
                    num |= 1 << count + 1;
                } else {
                    num |= 1 << count;
                    num &= ~(1 << count + 1);
                }
            }
            count += 2;
        }
        return num;
    }

    private int get(int num, int i) {
        return (num >> i) & 1;
    }

    /*
     * 利用掩码
     * */
    public int exchangeBits2(int num) {
        return (((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1));
    }
    /*
    * 0x为十六进制标识
    *   a代表10，即 1010，八个a表示八个1010，
    *   即 10101010101010101010101010101010
    *   0x55555555 同理
    *
    *   0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
    *   0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
    *   0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)
    *   0xcccccccc = 11001100110011001100110011001100(0和1每隔两位交替出现)
    *   0x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)
    *   0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)
    * */
}
