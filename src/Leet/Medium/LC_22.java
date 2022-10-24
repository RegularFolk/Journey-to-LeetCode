package Leet.Medium;

import java.util.LinkedList;
import java.util.List;

public class LC_22 {
    /*
     * dfs回溯，维护左右剩余括号数
     * */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs(ans, "", n, n);
        return ans;
    }

    private void dfs(List<String> ans, String s, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(s);
        }
        if (left > 0) {
            dfs(ans, s + "(", left - 1, right);
        }
        if (left < right) {
            dfs(ans, s + ")", left, right - 1);
        }
    }
}
