package Easy;

public class LC_67 {
    public static void main(String[] args) {

    }

    public static String addBinary(String a, String b) {
        int carry = 0;
        int sum;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 && j >= 0) {
            sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            if (sum > 1) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            stringBuilder.insert(0, sum);
            i--;
            j--;
        }
        StringBuilder insert = new StringBuilder(i >= 0 ? a : b);
        int pos = i >= 0 ? i : j;
        if (carry == 1) {
            while (pos >= 0) {
                if (insert.charAt(pos) == '1') {
                    insert.setCharAt(pos, '0');
                } else {
                    insert.setCharAt(pos, '1');
                    carry = 0;
                    break;
                }
                pos--;
            }
        }
        stringBuilder.insert(0, insert, 0, i >= 0 ? i + 1 : j + 1);
        if (carry == 1) {
            stringBuilder.insert(0, '1');
        }
        return stringBuilder.toString();
    }
}
