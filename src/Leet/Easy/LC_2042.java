package Leet.Easy;

public class LC_2042 {
    /*
     * ×Ö·û´®Ä£Äâ
     * */
    public boolean areNumbersAscending(String s) {
        String[] split = s.split("[ ]");
        int last = Integer.MIN_VALUE;
        for (String s1 : split) {
            boolean flag = isNum(s1);
            if (flag && Integer.parseInt(s1) > last) {
                last = Integer.parseInt(s1);
            } else if (flag) {
                return false;
            }
        }
        return true;
    }

    private boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
