package LeetCode.Hard;

import java.util.*;
import java.util.stream.Collectors;

public class LC_301 {
    /*
     * ����������BFS
     * ����ÿһ�㣬����ɾ����ǰ�е�ÿһ�������ַ����ж��Ƿ�Ϸ�
     * ����������£���һ�����жϺϷ����Ӵ�����ɾ���������ٵ��ַ���
     * */
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        if (valid(s.toCharArray(), -1)) {
            ans.add(s);
        } else {
            bfs(ans, s);
        }
        int maxLen = ans.stream().max(Comparator.comparingInt(String::length)).get().length();
        ans = ans.stream().filter(y -> y.length() == maxLen).collect(Collectors.toSet());
        return ans.stream().toList();
    }

    private void bfs(Set<String> ans, String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (isBracket(c)) {
                String dig = digOut(s, i);
                if (valid(chars, i)) {
                    // �����ǰ�ַ��������ţ�����ȥ����Ϸ�
                    ans.add(dig);
                }
                bfs(ans, dig);
            }
        }
    }

    private boolean valid(char[] chars, int idx) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (i == idx) continue;
            char c = chars[i];
            switch (c) {
                case ')':
                    if (!stack.isEmpty() && stack.getLast() == '(') {
                        stack.removeLast();
                    } else {
                        stack.addLast(c);
                    }
                    break;
                case '(':
                    stack.addLast(c);
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    private String digOut(String s, int idx) {
        return s.substring(0, idx) + s.substring(idx + 1);
    }

    private boolean isBracket(char c) {
        return c == '(' || c == ')';
    }
}
