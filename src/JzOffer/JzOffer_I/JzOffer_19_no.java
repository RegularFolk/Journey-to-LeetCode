package JzOffer.JzOffer_I;

public class JzOffer_19_no {
    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return false;
        }
        return matchCore(s, p);//利用递归化整为零
    }

    private boolean matchCore(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        char p0 = p.charAt(0), s0 = s.charAt(0);
        String pSub2 = p.substring(2), sSbu1 = s.substring(1);
        if (p.charAt(1) == '*') {
            if (p0 == s0 || p0 == '.') {
                return matchCore(sSbu1, pSub2) || matchCore(sSbu1, p) || matchCore(s, pSub2);
            } else {
                return matchCore(s, pSub2);
            }
        }
        if (s0 == p0 || p0 == '.') {
            return matchCore(s.substring(1), p.substring(1));
        }
        return false;
    }


    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
