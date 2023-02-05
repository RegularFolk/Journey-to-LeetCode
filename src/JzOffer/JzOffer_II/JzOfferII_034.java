package JzOffer.JzOffer_II;

public class JzOfferII_034 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alienOrder = new int[26];
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            alienOrder[chars[i] - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!qualified(words[i - 1], words[i], alienOrder)) return false;
        }
        return true;
    }

    //ÅÐ¶Ïword2ÊÇ·ñ´óÓÚword1
    private boolean qualified(String word1, String word2, int[] alienOrder) {
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        int len = Math.min(chars1.length, chars2.length), cursor = 0;
        while (cursor < len) {
            int c1 = alienOrder[chars1[cursor] - 'a'], c2 = alienOrder[chars2[cursor] - 'a'];
            if (c1 > c2) return false;
            else if (c1 < c2) return true;
            cursor++;
        }
        return cursor == chars1.length;
    }
}
