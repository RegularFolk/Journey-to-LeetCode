package Leet.Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

public class LC_17 {

    String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /*
     * 简单组合题
     * */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        LinkedList<String> ans = new LinkedList<>();
        permutation(ans, digits, new StringBuilder(), 0);
        return ans;
    }

    private void permutation(LinkedList<String> ans, String digits, StringBuilder builder, int cur) {
        if (cur == digits.length()) {
            ans.addLast(builder.toString());
            return;
        }
        int index = digits.charAt(cur) - '2';
        for (int i = 0; i < strings[index].length(); i++) {
            builder.append(strings[index].charAt(i));
            permutation(ans, digits, builder, cur + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    @Test
    public void s() {
        List<String> list = letterCombinations("9876543");
        ArrayUtil.printList(list);
    }
}
