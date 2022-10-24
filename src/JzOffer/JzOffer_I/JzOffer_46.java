package JzOffer.JzOffer_I;

public class JzOffer_46 {
    public int translateNum1(int num) { //dp思想
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    public int translateNum2(int num) {  //直接递归,实际上就是dp
        return trans(String.valueOf(num));
    }

    public int trans(String num) {
        if (num.length() < 1) {
            return 0;
        } else if (num.length() == 1) {
            return 1;
        } else if (num.charAt(0) != '0' && Integer.parseInt(num) <= 25) {
            return 2;
        } else {
            int ans = trans(num.substring(1));
            if (num.charAt(0) != '0' && Integer.parseInt(num.substring(0, 1)) <= 25) {
                ans += trans(num.substring(2));
            }
            return ans;
        }
    }
}
