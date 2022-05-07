package Easy;

public class LC_66 {
    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    break;
                } else {
                    digits[i] = 0;
                }
            }
        }
        if (digits[0] == 0) {
            int[] output = new int[digits.length + 1];
            output[0] = 1;
            System.arraycopy(digits, 0, output, 1, digits.length);
            return output;
        }
        return digits;
    }
}
