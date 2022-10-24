package Leet.Easy;

public class LC_942 {
    public int[] diStringMatch(String s) {
        int length = s.length();
        int min = 0, max = length;
        int[] ans = new int[length + 1];
        for (int i = 0; i < length; i++) {
            ans[i] = s.charAt(i) == 'I' ? min++ : max--;
        }
        ans[length] = min;  //填到最后仅剩一个，选择min或者max都是一样的
        return ans;
    }
}
