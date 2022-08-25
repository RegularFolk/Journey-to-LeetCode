package CrackCodeInterview.VIII_DanymicPlanning;

public class Interview_08_05 {
    /*
     * 利用奇偶优化，不含重复计算
     * */
    public int multiply(int A, int B) {
        if (A == 1 || B == 1) {
            return A == 1 ? B : A;
        }
        int bigger = Math.max(A, B), smaller = Math.min(A, B);
        if ((bigger & 1) == 1) {
            return smaller + multiply(bigger - 1, smaller);
        } else {
            int multiply = multiply(bigger >> 1, smaller);
            return multiply + multiply;
        }
    }
}
