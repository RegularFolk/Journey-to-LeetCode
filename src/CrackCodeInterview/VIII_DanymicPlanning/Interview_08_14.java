package CrackCodeInterview.VIII_DanymicPlanning;

import java.util.HashMap;

public class Interview_08_14 {
    /*
     * 暴力法，dfs枚举所有可能，在运算符两边加上括号
     * 超时，存在大量重复计算
     * */
    public int countEval1(String s, int result) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return s.charAt(0) == '0' + result ? 1 : 0;
        int ans = 0;
        for (int i = 1; i < s.length(); i += 2) {
            char c = s.charAt(i);
            String left = s.substring(0, i), right = s.substring(i + 1);
            //分别计算每一边的每种结果
            int leftTrue = countEval1(left, 1);
            int leftFalse = countEval1(left, 0);
            int rightTrue = countEval1(right, 1);
            int rightFalse = countEval1(right, 0);
            int totalTrue = 0, total = (leftFalse + leftTrue) * (rightFalse + rightTrue);
            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }
            ans += result == 1 ? totalTrue : total - totalTrue;
        }
        return ans;
    }

    /*
     * 利用map优化，记录已经计算过的子字符串
     * */
    public int countEval2(String s, int result) {
        return countEvalHelper1(s, result == 1, new HashMap<>());
    }

    private int countEvalHelper1(String s, boolean result, HashMap<String, Integer> map) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return (result && s.charAt(0) == '1') || (!result && s.charAt(0) == '0') ? 1 : 0;
        Integer mapValue = map.getOrDefault(result + s, null);
        if (mapValue != null) return mapValue;
        int ans = 0;
        for (int i = 1; i < s.length(); i += 2) {
            char c = s.charAt(i);
            String left = s.substring(0, i), right = s.substring(i + 1);
            //分别计算每一边的每种结果
            int leftTrue = countEvalHelper1(left, true, map);
            int leftFalse = countEvalHelper1(left, false, map);
            int rightTrue = countEvalHelper1(right, true, map);
            int rightFalse = countEvalHelper1(right, false, map);
            int totalTrue = 0, total = (leftFalse + leftTrue) * (rightFalse + rightTrue);
            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }
            ans += result ? totalTrue : total - totalTrue;
        }
        map.put(result + s, ans);
        return ans;
    }
}
