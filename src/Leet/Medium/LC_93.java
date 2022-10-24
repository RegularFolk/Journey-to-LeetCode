package Leet.Medium;

import java.util.LinkedList;
import java.util.List;

public class LC_93 {
    /*
     * 回溯
     * 插入三个点，有几种插法
     * 与LC_131分割类似
     * */
    private final List<String> ans = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        permutation(s, 0, 4, new LinkedList<>());
        return ans;
    }

    private void permutation(String s, int start, int count, LinkedList<String> path) {
        if (count == 0 && start == s.length()) ans.add(formString(path));
        else if (start < s.length()) {
            if (s.charAt(start) != '0') {
                for (int i = start; i < start + 3 && i < s.length(); i++) {
                    String substring = s.substring(start, i + 1);
                    if (Integer.parseInt(substring) <= 255) {
                        path.addLast(substring);
                        permutation(s, i + 1, count - 1, path);
                        path.removeLast();
                    }
                }
            } else {
                path.addLast("0");
                permutation(s, start + 1, count - 1, path);
                path.removeLast();
            }
        }
    }

    private String formString(LinkedList<String> path) {
        StringBuilder builder = new StringBuilder();
        for (String s : path) {
            builder.append(s).append(".");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
