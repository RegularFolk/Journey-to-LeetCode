package Leet.Medium;

public class LC_467 {
    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("abaab"));
    }

    public static int findSubstringInWraproundString(String p) { //思路，记录以每个字符为结尾的最长子串
        if (p.length() < 1) {
            return 0;
        }
        int[] record = new int[26];
        int ans = 0, maxLen = 1;
        record[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); i++) {
            int minus = p.charAt(i) - p.charAt(i - 1);
            if (minus == 1 || minus == -25) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            record[p.charAt(i) - 'a'] = Math.max(record[p.charAt(i) - 'a'], maxLen);
        }
        for (int i : record) {
            ans += i;
        }
        return ans;
    }
}
