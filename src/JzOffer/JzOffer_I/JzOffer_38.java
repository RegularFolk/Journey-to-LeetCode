package JzOffer.JzOffer_I;

import java.util.*;

public class JzOffer_38 {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Set<String> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder(s);
        doPermutation(set, stringBuilder, 0);
        return set.toArray(String[]::new); //为下方的缩写
        //return set.toArray(size -> new String[size]);
    }

    private void doPermutation(Set<String> set, StringBuilder s, int begin) { //从begin开始至末尾
        if (begin == s.length() - 1) {
            set.add(s.toString());
        } else {
            for (int i = begin; i < s.length(); i++) {
                swap(s, begin, i);
                doPermutation(set, s, begin + 1);
                swap(s, begin, i);
            }
        }
    }

    private void swap(StringBuilder s, int a, int b) {
        char c = s.charAt(a);
        s.setCharAt(a, s.charAt(b));
        s.setCharAt(b, c);
    }
}
