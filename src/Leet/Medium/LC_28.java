package Leet.Medium;

public class LC_28 {
    /*
     * KMP
     * java库中的contains方法实际上是暴力搜索
     * */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 & haystack.charAt(i) != needle.charAt(j + 1)) j = next[j];
            if (haystack.charAt(i) == needle.charAt(j + 1)) j++;
            if (j == needle.length() - 1) return i - needle.length() + 1;
        }
        return -1;
    }

    /*
     * 构建的next数组为前缀表数组全部减一
     * */
    private int[] getNext(String s) {
        int j = -1;//j指向前缀的末端
        int[] next = new int[s.length()];
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == s.charAt(j + 1)) j++;
            next[i] = j;
        }
        return next;
    }
}
