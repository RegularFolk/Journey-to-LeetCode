package CrackCodeInterview.VIII_DanymicPlanning;

import java.util.LinkedList;
import java.util.List;

public class Interview_08_07 {
    /*
    * 经典下一个排列问题
    * */
    public String[] permutation(String S) {
        List<String> ans = new LinkedList<>();
        nextPermutation(new StringBuilder(S), ans, 0);
        return ans.toArray(String[]::new);
    }

    private void nextPermutation(StringBuilder s, List<String> ans, int index) {
        if (index == s.length()) {
            ans.add(s.toString());
        }
        for (int i = index; i < s.length(); i++) {
            replace(s, i, index);
            nextPermutation(s,ans,index+1);
            replace(s, i, index);
        }
    }

    private void replace(StringBuilder s, int a, int b) {
        char as = s.charAt(a), bs = s.charAt(b);
        s.setCharAt(a, bs);
        s.setCharAt(b, as);
    }
}
