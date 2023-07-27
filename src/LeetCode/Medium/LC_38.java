package LeetCode.Medium;

public class LC_38 {
    /*
     * Ä£Äâ¼´¿É
     * Ë«Ö¸Õë
     * */
    public String countAndSay(int n) {
        String origin = "1";
        while (--n > 0) {
            origin = next(origin);
        }
        return origin;
    }

    private String next(String s) {
        StringBuilder builder = new StringBuilder();
        int l = 0, r = 0;
        while (r < s.length()) {
            while (r < s.length() && s.charAt(l) == s.charAt(r)) {
                r++;
            }
            builder.append(r - l).append(s.charAt(l));
            l = r;
        }
        return builder.toString();
    }

}
