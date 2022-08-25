package CrackCodeInterview.VIII_DanymicPlanning;

import java.util.LinkedList;
import java.util.List;

public class Interview_08_09_mark {
    /*
     * 维护左右括号的数量，进行迭代
     * */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs(ans, n, n, "");
        return ans;
    }

    private void dfs(List<String> ans, int left, int right, String s) {
        if (left == 0 && right == 0) {
            ans.add(s);
        }
        if (left > 0) {
            dfs(ans, left - 1, right, s + "(");
        }
        if (left < right) {
            dfs(ans, left, right - 1, s + ")");
        }
    }
}
