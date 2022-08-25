package CrackCodeInterview.I_Array_String;

public class Interview_01_06 {
    public String compressString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int cursor1 = 0, cursor2 = 0;
        while (cursor2 < s.length()) {
            builder.append(s.charAt(cursor1++));
            int count = 1;
            while (cursor1 < s.length() && s.charAt(cursor1) == s.charAt(cursor1 - 1)) {
                count++;
                cursor1++;
            }
            builder.append(count);
            cursor2 = cursor1;
        }
        return builder.length() > s.length() ? s : builder.toString();
    }
}
