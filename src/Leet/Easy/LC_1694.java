package Leet.Easy;

public class LC_1694 {
    /*
     * ×Ö·û´®Ä£Äâ
     * */
    public String reformatNumber(String number) {
        int count = 0, curLen = 0;
        StringBuilder builder = new StringBuilder();
        char[] chars = number.toCharArray();
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                builder.append(aChar);
                count++;
                curLen++;
                if (curLen == 3) {
                    builder.append("-");
                    curLen = 0;
                }
            }
        }
        if (curLen == 1 && count > 2) {
            builder.insert(builder.length() - 1, builder.charAt(builder.length() - 3));
            builder.deleteCharAt(builder.length() - 4);
        }
        if (builder.charAt(builder.length() - 1) == '-') builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
