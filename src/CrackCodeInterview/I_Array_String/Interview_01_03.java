package CrackCodeInterview.I_Array_String;

public class Interview_01_03 {
    public String replaceSpaces(String s, int length) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String blank = "%20";
        for (int i = 0; i < length; i++) {
            char sc = s.charAt(i);
            if (sc == ' ') {
                stringBuilder.append(blank);
            } else {
                stringBuilder.append(sc);
            }
        }
        return stringBuilder.toString();
    }
}
