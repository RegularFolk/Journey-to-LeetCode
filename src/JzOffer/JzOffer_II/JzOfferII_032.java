package JzOffer.JzOffer_II;

public class JzOfferII_032 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        int[] map = new int[26];
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        for (char c : sc) map[c - 'a']++;
        for (char c : tc) if (map[c - 'a']-- == 0) return false;
        return true;
    }
}
