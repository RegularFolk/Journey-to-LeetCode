package JzOffer.JzOffer_I;

public class JzOffer_64 {
    public int sumNums1(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums1(n - 1)) > 0;  //利用逻辑运算符的短路特性
        return sum;
    }

    public int sumNums2(int n) {
        try {  //制造异常作为递归终点
            int i = 1 % n;
        } catch (Exception e) {
            return 0;
        }
        return n + sumNums2(n - 1);
    }

}
