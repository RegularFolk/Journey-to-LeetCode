package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_1704 {
    /*
     * Ä£Äâ
     * */
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0, mid = chars.length >> 1;
        for (int i = 0; i < mid; i++) {
            if (isVowel(chars[i])) l++;
            if (isVowel(chars[i + mid])) r++;
        }
        return l == r;
    }

    private final HashSet<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    private boolean isVowel(char c) {
        return set.contains(c);
    }

}
