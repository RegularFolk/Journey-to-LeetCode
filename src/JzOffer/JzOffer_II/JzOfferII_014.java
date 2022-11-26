package JzOffer.JzOffer_II;

import java.util.Arrays;

public class JzOfferII_014 {
    public boolean checkInclusion(String s1, String s2) {
        int[] mark = new int[26];
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        for (char c : chars1) {
            mark[c - 'a']++;
        }
        for (int i = chars1.length - 1; i < chars2.length; i++) {
            if (mark[chars2[i] - 'a'] != 0) {
                int[] copy = Arrays.copyOf(mark, mark.length);
                int cur = 0;
                while (cur < chars1.length) {
                    int index = chars2[i - cur] - 'a';
                    if (copy[index] != 0) copy[index]--;
                    else break;
                    cur++;
                }
                if (cur == chars1.length) return true;
                else i += chars1.length - cur - 1;
            }
        }
        return false;
    }

}
