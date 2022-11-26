package LeetCode.Easy;

public class LC_1684 {
    /*
     * Ä£Äâ
     * */
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        int ans = 0;
        for (int i = 0; i < allowed.length(); i++) {
            map[allowed.charAt(i) - 'a'] = true;
        }
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!map[word.charAt(i) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
        }
        return ans;
    }
}
