package CrackCodeInterview.XVI_Medium;

public class Interview_16_09 {
    static class Operations {

        public Operations() {

        }

        /*
         * 将ab中绝对值较小的数取反
         * */
        public int minus(int a, int b) {
            return a + negative(b);
        }

        private int negative(int b) {
            int neg = 0;
            int sign = b > 0 ? -1 : 1;
            while (b != 0) {
                neg += sign;
                b += sign;
            }
            return neg;
        }

        public int multiply(int a, int b) {
            if (a == 0 || b == 0) return 0;
            if (a > 0 && b < 0 || a < 0 && b > 0) {
                if (a > 0) return negative(multiply(a, negative(b)));
                else return negative(multiply(negative(a), b));
            }
            if (a < 0) return multiply(negative(a), negative(b));
            if (b > a) return multiply(b, a);
            int count = 1;
            while (count++ < b) {
                a += a;
            }
            return a;
        }

        public int divide(int a, int b) {
            if (a == 0) return 0;
            if (a > 0 && b < 0 || a < 0 && b > 0) {
                if (a > 0) return negative(divide(a, negative(b)));
                else return negative(divide(negative(a), b));
            }
            if (a < 0) return divide(negative(a), negative(b));
            int count = 0;
            while (b < a) {
                b += b;
                count++;
            }
            return count;
        }
    }
}
