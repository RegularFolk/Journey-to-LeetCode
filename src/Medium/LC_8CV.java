package Medium;

import java.util.HashMap;
import java.util.Map;

public class LC_8CV {

    static class Solution {
        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                automaton.get(str.charAt(i));
            }
            return (int) (automaton.sign * automaton.ans);
        }
    }

    static class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }
//    public int myAtoi(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        boolean positive = true;
//        long num = 0;
//        int cursor = 0;
//        while (s.charAt(cursor) == ' ') {
//            cursor++;
//        }
//        if (s.charAt(cursor) == '-' || s.charAt(cursor) == '+') {
//            positive = s.charAt(cursor) == '+';
//            cursor++;
//        } else if (cursor > s.length() - 1 || s.charAt(cursor) > '9' || s.charAt(cursor) < '0') {
//            return 0;
//        }
//        while (cursor < s.length()) {
//            if (s.charAt(cursor) == '0') {
//                if (num != 0) {
//                    num *= 10;
//                }
//            } else if (s.charAt(cursor) > '0' && s.charAt(cursor) <= '9') {
//                if (num == 0) {
//                    num = s.charAt(cursor) - '0';
//                } else {
//                    num *= 10;
//                    num += s.charAt(cursor) - '0';
//                }
//            } else if (s.charAt(cursor) == '.') {
//                break;
//            }
//            cursor++;
//        }
//        num *= positive ? 1 : -1;
//        if (num > Integer.MAX_VALUE) {
//            num = Integer.MAX_VALUE;
//        } else if (num < Integer.MIN_VALUE) {
//            num = Integer.MIN_VALUE;
//        }
//        return (int) num;
//    }
}
