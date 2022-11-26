package JzOffer.JzOffer_II;

public class JzOfferII_016 {
    /*
     * ����˫ָ��+����������ǳ������
     * ֻ֧�ִ�Сд��ĸ����ϧ�����������ַ�
     * */
    public int lengthOfLongestSubstring(String s) {
        int map = 0, ans = 0, l = 0, r = 0;
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            int offset = chars[r++] - 'a';
            while ((((map >> offset) & 1) == 1) && l < r) map &= ~(1 << (chars[l++] - 'a'));
            map |= 1 << offset;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }

    //�����ַ����˶������ʹ������
    public int lengthOfLongestSubstring1(String s) {
        boolean[] set = new boolean[128];
        int ans = 0, l = 0, r = 0;
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            while (set[chars[r]] && l < r) set[chars[l++]] = false;
            set[chars[r++]] = true;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
