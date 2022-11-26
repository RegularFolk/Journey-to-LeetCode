package JzOffer.JzOffer_II;

public class JzOfferII_002 {
    /*
    * Î»ÔËËã
    * Ä£Äâ
    * */
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) return addBinary(b, a);
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        char[] ac = a.toCharArray(), bc = b.toCharArray();
        int offset = '0' + '0';
        for (int i = 0; i < b.length(); i++) {
            int indexA = a.length() - i - 1, indexB = b.length() - i - 1;
            int add = ac[indexA] + bc[indexB] + carry - offset;
            ans.append(add & 1);
            carry = add >> 1;
        }
        for (int i = b.length(); i < a.length(); i++) {
            int indexA = a.length() - i - 1;
            int add = ac[indexA] + carry - '0';
            ans.append(add & 1);
            carry = add >> 1;
        }
        if (carry != 0) ans.append(1);
        return ans.reverse().toString();
    }
}
