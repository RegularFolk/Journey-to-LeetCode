package JzOffer.JzOffer_II;

public class JzOfferII_019 {
    public boolean validPalindrome(String s) {
        char[] sc = s.toCharArray();
        int l = 0, r = sc.length - 1;
        while (l < r) {
            if (sc[l++] != sc[r--]) return chance(sc, l, r + 1) || chance(sc, l - 1, r);
        }
        return true;
    }

    private boolean chance(char[] sc, int l, int r) {
        while (l < r) {
            if (sc[l++] != sc[r--]) return false;
        }
        return true;
    }
}
