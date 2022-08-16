package JzOffer;

import java.util.LinkedList;
import java.util.List;

public class JzOffer_58_1 {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        List<String> list = new LinkedList<>();
        int cursor = 0, len = s.length();
        while (cursor < len) {
            while (cursor < len && s.charAt(cursor) == ' ') {
                cursor++;
            }
            int mark = cursor;
            while (cursor < len && s.charAt(cursor) != ' ') {
                cursor++;
            }
            if (mark < cursor) {
                list.add(s.substring(mark, cursor));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            ans.append(list.get(i)).append(" ");
        }
        return ans.append(list.get(0)).toString();
    }
}
