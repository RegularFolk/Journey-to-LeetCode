package Medium;

public class LC_522 {

    //若一个子序列为特殊序列，则该子序列所在的字符串也是特殊序列，暴力模拟，比较时利用双指针降低复杂度
    public int findLUSlength(String[] strs) {
        int len = strs.length, ans = -1;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (i != j && check(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private boolean check(String s1, String s2) {
        int cur1 = 0, cur2 = 0;
        while (cur1 < s1.length() && cur2 < s2.length()) {
            if (s1.charAt(cur1) == s2.charAt(cur2)) {
                cur1++;
            }
            cur2++;
        }
        return cur1 == s1.length();
    }
}
