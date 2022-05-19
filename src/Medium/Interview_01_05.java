package Medium;

public class Interview_01_05 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("intention", "execution"));
    }

    public static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int cursor1 = 0, cursor2 = 0;
        int sLen = second.length() - 1;
        int fLen = first.length() - 1;
        while (cursor1 <= fLen && cursor2 <= sLen) {
            if (first.charAt(cursor1) != second.charAt(cursor2)) {
                break;
            } else {
                cursor1++;
                cursor2++;
            }
        }
        int cursor3 = 0, cursor4 = 0;
        while (cursor3 < first.length() && cursor4 < second.length()) {
            if (first.charAt(fLen - cursor3) != second.charAt(sLen - cursor4)) {
                return first.length() >= second.length() ? cursor3 + cursor1 == fLen : cursor2 + cursor4 == sLen;
            } else {
                cursor3++;
                cursor4++;
            }
        }
        return true;
    }
}
