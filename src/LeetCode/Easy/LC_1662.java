package LeetCode.Easy;

public class LC_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int cur1 = 0, cur2 = 0, no1 = 0, no2 = 0;
        while (no1 < word1.length && no2 < word2.length) {
            if (word1[no1].charAt(cur1) != word2[no2].charAt(cur2)) return false;
            cur1++;
            cur2++;
            if (cur1 == word1[no1].length()) {
                cur1 = 0;
                no1++;
            }
            if (cur2 == word2[no2].length()) {
                cur2 = 0;
                no2++;
            }
        }
        return no1 == word1.length && no2 == word2.length;
    }
}
