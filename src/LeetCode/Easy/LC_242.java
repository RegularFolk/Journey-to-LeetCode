package LeetCode.Easy;

public class LC_242 {
    /*
    * 利用数组做字符串映射
    * */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] dic = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dic[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (dic[index] == 0) return false;
            else dic[index]--;
        }
        return true;
    }
}
