package CrackCodeInterview;

import org.junit.Test;

public class Interview_01_05 {
    @Test
    public void t() {
        System.out.println(oneEditAway2("islander", "slander"));
    }

    public boolean oneEditAway1(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int cursor1 = 0, cursor2 = 0;
        int sLen = second.length() - 1;
        int fLen = first.length() - 1;
        while (cursor1 <= fLen && cursor2 <= sLen) {  //从前往后找一个不同
            if (first.charAt(cursor1) != second.charAt(cursor2)) {
                break;
            } else {
                cursor1++;
                cursor2++;
            }
        }
        int cursor3 = 0, cursor4 = 0;
        while (cursor3 < first.length() && cursor4 < second.length()) {  //从后往前找一个不同
            if (first.charAt(fLen - cursor3) != second.charAt(sLen - cursor4)) { //判断是不是找的同一个不同
                return first.length() >= second.length() ? cursor3 + cursor1 == fLen : cursor2 + cursor4 == sLen;
            } else {
                cursor3++;
                cursor4++;
            }
        }
        return true;
    }

    public boolean oneEditAway2(String first, String second) {
        if (first == null && second == null) {
            return true;
        } else if (first == null && second.length() > 1 || second == null && first.length() > 1) {
            return false;
        }
        int len1 = first.length(), len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        boolean diff = false;
        if (len1 == len2) {  //只允许一个不同
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!diff) {
                        diff = true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            for (int cur1 = 0, cur2 = 0; cur1 < len1 && cur2 < len2; cur1++, cur2++) {
                if (first.charAt(cur1) != second.charAt(cur2)) {
                    if (diff) {
                        return false;
                    } else {
                        diff = true;
                        if (len1 > len2) {
                            cur2--;
                        } else {
                            cur1--;
                        }
                    }
                }
            }
        }
        return true;
    }
}
