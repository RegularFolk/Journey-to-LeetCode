package LeetCode.Medium;

import org.junit.Test;

import java.util.*;

public class LC_2375 {

    @Test
    public void t() {
        String s = smallestNumber("IIIDIDDD");
        //String s = smallestNumber("I");
        System.out.println("s = " + s);
    }

    public String smallestNumber(String pattern) {  //暴力模拟,遍历所有可能的排列,代码还可以更简洁
        Set<Character> set = new TreeSet<>();
        return fun(new StringBuilder(), new StringBuilder(pattern), set).toString();
    }

    private StringBuilder fun(StringBuilder cur, StringBuilder pattern, Set<Character> set) {
        int clen = cur.length(), plen = pattern.length();
        char old = clen == 0 ? '0' : cur.charAt(clen - 1), pc = plen == 0 ? '0' : pattern.charAt(0);
        for (int i = '1'; i <= '9'; i++) {
            char c = (char) i;
            if (old == '0' || (pc == 'I' && !set.contains(c) && c > old) || (pc == 'D' && !set.contains(c) && c < old)) {
                if (plen == 1 && clen != 0) {
                    return cur.append(c);
                } else {
                    set.add(c);
                    StringBuilder ans = fun(new StringBuilder(cur).append(c), new StringBuilder(pattern.substring(old == '0' ? 0 : 1)), set);
                    if (ans != null) {
                        return ans;
                    } else {
                        set.remove(c);
                    }
                }
            }
        }
        return null;
    }
}
