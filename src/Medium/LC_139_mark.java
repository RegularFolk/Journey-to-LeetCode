package Medium;

import java.util.List;

public class LC_139_mark {
    /*
     * ����
     * ���鳬ʱ
     * �Ż�wordDictҲ�ᳬʱ
     * ʱ�临�Ӷ� 2^n
     * ���ü����������ͨ����visited[i]��ʾi���ƥ���ϵĳ��ȣ��ٴ�������������������ݹ�
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
     * ��̬�滮
     * dp[i]��ʾ 0 ~ i-1 ���Ա����
     * dp[i] = dp[k] && word.contains(s.subString(k+1,i)) ,k �� [0 ~ i-1];
     * ʱ�临�Ӷ� k * n^2,kΪwordDict����
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