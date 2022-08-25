package CrackCodeInterview.VIII_DanymicPlanning;

import java.util.LinkedList;
import java.util.List;

public class Interview_08_08 {
    /*
     * 大致与上一题相同
     *  用一个set记录已经交换过的字符
     *  自己用数组实现比用set快
     * */
    public String[] permutation(String S) {
        List<String> ans = new LinkedList<>();
        nextPermutation(new StringBuilder(S), ans, 0);
        return ans.toArray(String[]::new);
    }

    private void nextPermutation(StringBuilder s, List<String> ans, int index) {
        if (index == s.length()) {
            ans.add(s.toString());
            return;
        }
        boolean[] upper = new boolean[26], lower = new boolean[26];
        for (int i = index; i < s.length(); i++) {
            char si = s.charAt(i);
            if ((isLower(si) && !lower[si - 'a']) || (isUpper(si) && !upper[si - 'A'])) {
                if (isLower(si)) lower[si - 'a'] = true;
                else upper[si - 'A'] = true;
                replace(s, i, index);
                nextPermutation(s, ans, index + 1);
                replace(s, i, index);
            }
        }
    }

    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private void replace(StringBuilder s, int a, int b) {
        char as = s.charAt(a), bs = s.charAt(b);
        s.setCharAt(a, bs);
        s.setCharAt(b, as);
    }
}
