package Leet.Medium;

import org.junit.Test;

public class LC_394 {
    /*
    * �������ֵݹ鴦��
    * ע�����ֵ�λ��
    * */
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char si = chars[i];
            if (isNum(si)) {
                i = process(chars, i, ans);
            } else {
                ans.append(si);
            }
        }
        return ans.toString();
    }

    /*
    * �ݹ鴦�����֣����ض�Ӧ�������ŵ��±�
    * */
    private int process(char[] chars, int index, StringBuilder ans) {
        StringBuilder builder = new StringBuilder();
        int cursor = index, len = 0;
        while (isNum(chars[len + index])) {
            len++;
        }
        String num = new String(chars, index, len);
        cursor += len + 1;
        while (chars[cursor] != ']') {
            if (isNum(chars[cursor])) {
                cursor = process(chars, cursor, builder);
            } else {
                builder.append(chars[cursor]);
            }
            cursor++;
        }
        ans.append(builder.toString().repeat(Integer.parseInt(num)));
        return cursor;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    @Test
    public void s() {
        String string = decodeString("3[a]2[bc]");
        System.out.println(string);
    }
}
