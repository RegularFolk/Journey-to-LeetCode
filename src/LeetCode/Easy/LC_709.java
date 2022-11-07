package LeetCode.Easy;

public class LC_709 {
    public String toLowerCase(String s) {
        StringBuilder stringBuilders = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(s.charAt(i))) {
                stringBuilders.append(Character.toLowerCase(s.charAt(i)));
            } else {
                stringBuilders.append(s.charAt(i));
            }
        }
        return stringBuilders.toString();
    }
}
