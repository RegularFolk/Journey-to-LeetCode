package JzOffer;

public class JzOffer_50 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        int[] hash = new int[26], index = new int[26];
        int min = 60000;
        char ans = ' ';
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            hash[c]++;
            index[c] = i;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 1 && index[i] < min) {
                ans = (char) (i + '0');
                min = index[i];
            }
        }
        return ans;
    }
}
