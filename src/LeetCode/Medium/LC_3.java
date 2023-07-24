package LeetCode.Medium;

import org.junit.Test;

 class LC_3 {

    /*
     * һ��bitλ��ʾ�Ƿ���ֹ�
     * ˫ָ��
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        boolean[] map = new boolean[130];
        int l = 0, r = 0, ans = 0, count = 0;
        while (r < chars.length) {
            //��ǰ�ַ�û�г��ֹ�����ָ������
            while (map[chars[r]] && l <= r) {
                map[chars[l]] = false;
                l++;
                count--;
            }
            count++;
            map[chars[r]] = true;
            r++;
            ans = Math.max(ans, count);
        }
        return ans;
    }


    public void x() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

class redo_3 {
    /*
     * λ���� + ˫ָ��
     * */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = 0, l = 0, r = 0;
        boolean[] mark = new boolean[130];
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            char c = chars[r];
            while (mark[c] && l <= r) {
                mark[chars[l]] = false;
                l++;
            }
            mark[c] = true;
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
