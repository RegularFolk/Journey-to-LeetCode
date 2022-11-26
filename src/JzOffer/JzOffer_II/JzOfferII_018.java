package JzOffer.JzOffer_II;

import org.junit.Test;

public class JzOfferII_018 {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) builder.append(c);
            else if (c >= 'A' && c <= 'Z') builder.append((char) (c - 'A' + 'a'));
        }
        int l = 0, r = builder.length() - 1;
        while (l < r) if (builder.charAt(l++) != builder.charAt(r--)) return false;
        return true;
    }

    @Test
    public void x() {
        System.out.println(isPalindrome("0P"));
    }
}
