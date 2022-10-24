package Leet.Easy;

public class LC_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] fre = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            fre[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (fre[idx] == 0) {
                return false;
            } else {
                fre[idx]--;
            }
        }
        return true;
    }
}
