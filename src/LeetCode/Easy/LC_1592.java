package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class LC_1592 {
    /*
     * ×Ö·û´®Ä£Äâ
     * */
    public String reorderSpaces(String text) {
        StringBuilder ans = new StringBuilder();
        int count = 0, cursor = 0;
        char[] chars = text.toCharArray();
        List<String> list = new ArrayList<>();
        while (cursor < chars.length) {
            int mark = -1;
            while (cursor < chars.length && chars[cursor] == ' ') {
                cursor++;
                count++;
            }
            if (cursor < chars.length) mark = cursor;
            while (cursor < chars.length && chars[cursor] != ' ') cursor++;
            if (mark != -1) {
                list.add(String.valueOf(chars, mark, cursor - mark));
            }
        }
        int gap = list.size() == 1 ? 0 : count / (list.size() - 1), left = list.size() == 1 ? count : count - (gap * (list.size() - 1));
        ans.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            ans.append(" ".repeat(gap)).append(list.get(i));
        }
        ans.append(" ".repeat(left));
        return ans.toString();
    }
}
