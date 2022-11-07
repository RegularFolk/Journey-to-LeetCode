package LeetCode.Hard;

import java.util.Stack;

public class LC_32 {
    /*
     * 困难一次过！！！！！
     * 利用栈和布尔数组
     * 利用布尔数组记录多少到多少下标的子串可以形成有效括号
     * 关键在于栈顶字符对应的数组下标cur的维护
     * 时间复杂度为n
     * */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] map = new boolean[s.length()];
        int cur = 0; //cur记录栈顶字符对应数组下标
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
                cur = i;
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(chars[i]);
                } else {
                    stack.pop();
                    map[cur] = true;
                    map[i] = true;
                    while (cur >= 0 && map[cur]) {
                        cur--;//对cur的位置进行调整
                    }
                }
            }
        }
        int max = 0, rec = 0;
        for (boolean b : map) {
            rec = b ? rec + 1 : 0;
            max = Math.max(max, rec);
        }
        return max;
    }
}
