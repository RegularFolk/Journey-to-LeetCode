package LeetCode.Medium;

public class LC_397 {
    public static void main(String[] args) {

    }

    /**
     *  ����λ����
     *  >>��<<Ϊ�߼����ƺ��߼�����
     *  &Ϊ��λ��
     */
    public static int integerReplacement(int n) {
        int count = 0;
        long n2 = n;
        while (n2 != 1) {
            if (n2 % 2 == 0) {
                n2 >>= 1;
            } else {
                if (n2 != 3 && ((n2 >> 1 & 1) == 1)) {
                    n2++;
                } else {
                    n2--;
                }
            }
            count++;
        }
        return count;
    }
}
