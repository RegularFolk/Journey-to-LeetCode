package LeetCode.Hard;

import java.util.Stack;

public class LC_32 {
    /*
     * ����һ�ι�����������
     * ����ջ�Ͳ�������
     * ���ò��������¼���ٵ������±���Ӵ������γ���Ч����
     * �ؼ�����ջ���ַ���Ӧ�������±�cur��ά��
     * ʱ�临�Ӷ�Ϊn
     * */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] map = new boolean[s.length()];
        int cur = 0; //cur��¼ջ���ַ���Ӧ�����±�
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
                        cur--;//��cur��λ�ý��е���
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
