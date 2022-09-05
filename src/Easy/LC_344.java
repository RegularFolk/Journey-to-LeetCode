package Easy;

public class LC_344 {
    /*
     * 利用双指针原地翻转
     * */
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }
}
