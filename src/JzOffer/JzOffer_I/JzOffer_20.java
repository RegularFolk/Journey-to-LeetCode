package JzOffer.JzOffer_I;

import org.junit.Test;

public class JzOffer_20 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        boolean numeric = scanInteger(stringBuilder); //检查开头数字
        if (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '.') {  //检查小数点
            stringBuilder.deleteCharAt(0);
            numeric = scanUnsignedInteger(stringBuilder) || numeric;
        }
        if (stringBuilder.length() > 0) {
            char c = stringBuilder.charAt(0);
            if (c == 'e' || c == 'E') {
                stringBuilder.deleteCharAt(0); //检查e
                numeric = numeric && scanInteger(stringBuilder); //e之后还有数字
            }
        }
        return numeric && stringBuilder.length() == 0;
    }

    private boolean scanInteger(StringBuilder chars) {
        if (chars.length() == 0) {
            return false;
        }
        char c = chars.charAt(0);
        if (c == '-' || c == '+') {
            chars.deleteCharAt(0);
        }
        return scanUnsignedInteger(chars);
    }

    private boolean scanUnsignedInteger(StringBuilder chars) {
        if (chars.length() == 0) {
            return false;
        }
        int cursor = 0;
        while (cursor < chars.length() && chars.charAt(cursor) >= '0' && chars.charAt(cursor) <= '9') {
            cursor++;
        }
        chars.delete(0, cursor);
        return cursor > 0;
    }

    @Test
    public void test() {
        System.out.println(isNumber("0.8"));
    }
}
