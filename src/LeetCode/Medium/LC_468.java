package LeetCode.Medium;

public class LC_468 {
    public static void main(String[] args) {
        System.out.println(validIPAddress("12..33.4"));
    }

    public static String validIPAddress(String queryIP) {
        String neither = "Neither";
        String[] split = queryIP.split("[.:]");
        int sLen = split.length, len = queryIP.length();
        int one = 0, two = 0;
        for (int i = 0; i < len; i++) { //先走一遍，判断有没有分隔符上的错误
            char c = queryIP.charAt(i);
            if (c == '.') {
                one++;
            } else if (c == ':') {
                two++;
            }
            if ((one > 0 && two > 0) || one > 3 || two > 7) {
                return neither;
            }
        }
        if (sLen == 4) {
            for (String s : split) {
                if ((s == null || s.length() == 0) || (s.charAt(0) == '0' && s.length() > 1) || (s.length() > 3)) {
                    return neither;
                } else {
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c > '9' || c < '0') {
                            return neither;
                        }
                    }
                    if (Integer.parseInt(s) > 255) {
                        return neither;
                    }
                }
            }
            return "IPv4";
        } else if (sLen == 8) {
            for (String s : split) {
                if (s == null || s.length() == 0 || s.length() > 4) {
                    return neither;
                }
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (!Character.isDigit(c) && (Character.toLowerCase(c) > 'f')) {
                        return neither;
                    }
                }
            }
            return "IPv6";
        } else {
            return neither;
        }
    }
}
