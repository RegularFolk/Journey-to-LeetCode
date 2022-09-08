package Medium;

import java.util.LinkedList;
import java.util.List;

public class LC_131 {
    /*
     * ����
     * */
    private final List<List<String>> ans = new LinkedList<>();
    private final LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        permutation(s, 0, path);
        return ans;
    }

    private void permutation(String s, int start, LinkedList<String> path) {
        if (start == s.length()) ans.add(List.copyOf(path));
        for (int i = start; i < s.length(); i++) {
            if (confirm(s, start, i)) {//ȷ��ÿ�ηָ�������Ӵ�Ϊ���ģ�������ȫ�����ǻ���
                path.addLast(s.substring(start, i + 1));
                permutation(s, i + 1, path);
                path.removeLast();
            }
        }
    }

    private boolean confirm(String s, int left, int right) {
        for (int l = left, r = right; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }
}
