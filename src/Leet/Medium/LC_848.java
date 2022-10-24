package Leet.Medium;

public class LC_848 {
    public static String shiftingLetters(String s, int[] shifts) {
        int bef = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shifts[i] = (shifts[i] % 26 + bef) % 26;
            bef = shifts[i];
        }
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append((char) ((s.charAt(i) + shifts[i] - 'a') % 26 + 'a'));
        }
        return stringBuilder.toString();
    }
}
