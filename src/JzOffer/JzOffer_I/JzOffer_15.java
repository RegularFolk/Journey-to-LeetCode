package JzOffer.JzOffer_I;

public class JzOffer_15 {
    public int hammingWeight(int n) {//不考虑负数
        int count = 0, flag = 1;
        while (n != 0) {
            if ((n & flag) == 1) {
                count++;
            }
            n >>>= 1;  //java中的无符号右移,三个箭头
        }
        return count;
    }

    public int hammingWeight1(int n) { //考虑n为负数
        int count = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) >= 1) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) { //书上第三种解法
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n; //减一后按位与自己，相比于原来会少一个1
        }
        return count;
    }
}
