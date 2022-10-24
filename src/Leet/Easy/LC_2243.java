package Leet.Easy;

public class LC_2243 {
    /*
     * µÝ¹é+Ä£Äâ
     * */
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        StringBuilder builder = new StringBuilder();
        int cursor = 0;
        while (cursor < s.length()) {
            int sum = 0;
            for (int i = 0; i < k && cursor < s.length(); i++, cursor++) {
                sum += s.charAt(cursor) - '0';
            }
            builder.append(sum);
        }
        return digitSum(builder.toString(), k);
    }
}
