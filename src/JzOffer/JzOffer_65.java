package JzOffer;

public class JzOffer_65 {
    public int add(int a, int b) { //位运算
        int sum = a ^ b, carry = a & b;
        while (carry != 0) {
            carry <<= 1;
            int temp = sum;
            sum ^= carry;
            carry &= temp;
        }
        return sum;
    }
}
