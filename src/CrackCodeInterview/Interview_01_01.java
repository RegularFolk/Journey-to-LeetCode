package CrackCodeInterview;

public class Interview_01_01 {
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        if (astr.length() > 26) {//大于26肯定存在相同的，加分点
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int c = astr.charAt(i) - 'a';
            if (map[c] != 0) {
                return false;
            }
            map[c]++;
        }
        return true;
    }
}
