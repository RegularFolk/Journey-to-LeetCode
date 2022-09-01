package Medium;

import java.util.List;

public class LC_139_mark {
    /*
     * 回溯
     * 无情超时
     * 优化wordDict也会超时
     * 时间复杂度 2^n
     * 利用记忆数组可以通过，visited[i]表示i这格被匹配上的长度，再次遇见可以跳过，不如递归
     * */
    public boolean wordBreak1(String s, List<String> wordDict) {
        process(wordDict);
        return dfs(s, wordDict, 0, new int[s.length()]);
    }

    private void process(List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            String remove = wordDict.remove(i);
            if (!dfs(remove, wordDict, 0, new int[remove.length()])) {
                wordDict.add(remove);
            }
        }
    }

    private boolean dfs(String s, List<String> wordDict, int start, int[] visited) {
        if (start == s.length()) {
            return true;
        }
        if (visited[start] > 0) {
            return dfs(s, wordDict, start + visited[start], visited);
        }
        for (String word : wordDict) {
            if (s.startsWith(word, start)) {
                visited[start] = word.length();
                if (dfs(s, wordDict, start + word.length(), visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * 动态规划
     * dp[i]表示 0 ~ i-1 可以被拆分
     * dp[i] = dp[k] && word.contains(s.subString(k+1,i)) ,k ∈ [0 ~ i-1];
     * 时间复杂度 k * n^2,k为wordDict长度
     * */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}