package JzOffer.JzOffer_II;

public class JzOfferII_005 {
    /*
     * 利用一个26位数记录每个单词的字母出现情况
     * */
    public int maxProduct(String[] words) {
        int ans = 0;
        int[] status = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int mark = 0;
            for (char c : chars) {
                mark |= 1 << (c - 'a');
            }
            status[i] = mark;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((status[i] & status[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
