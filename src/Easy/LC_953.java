package Easy;

import java.util.HashMap;
import java.util.Map;

public class LC_953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> grammar = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            grammar.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compareTo(words[i], words[i + 1], grammar) > 0) {
                return false;
            }
        }
        return true;
    }

    int compareTo(String a, String b, Map<Character, Integer> grammar) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            char charA = a.charAt(i);
            char CharB = b.charAt(i);
            if (charA != CharB) {
                return grammar.get(charA) - grammar.get(CharB);
            }
        }
        return a.length() - b.length();
    }
}
