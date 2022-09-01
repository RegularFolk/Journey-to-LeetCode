package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LC_96 {
    /*
     * 递归法
     *   当选定一个k作为根时，左子树的范围为1~k-1,右子树的范围为k+1~n
     * 究极暴力，2166ms，击败5.33%
     * */
    public int numTrees(int n) {
        return helper(1, n);
    }

    private int helper(int left, int right) {
        if (left >= right) {
            return 1;
        }
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans += helper(left, i - 1) * helper(i + 1, right);
        }
        return ans;
    }

    /*
     * 利用散列表优化，避免重复计算
     * 16ms
     * 换成自己的类
     * 3ms
     * */
    Map<Entry, Integer> map = new HashMap<>();

    public int numTrees1(int n) {
        return helper1(1, n);
    }

    private int helper1(int left, int right) {
        if (left >= right) {
            return 1;
        }
        int ans = 0;
        for (int i = left; i <= right; i++) {
            Entry key = new Entry(left, i, right);
            Integer integer = map.getOrDefault(key, -1);
            if (integer != -1) {
                ans += integer;
            } else {
                int value = helper1(left, i - 1) * helper1(i + 1, right);
                ans += value;
                map.put(key, value);
            }
        }
        return ans;
    }

    private static class Entry {
        int left, i, right;

        public Entry(int left, int i, int right) {
            this.left = left;
            this.i = i;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return left == entry.left && i == entry.i && right == entry.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, i, right);
        }
    }

    /*
     * 用三维数组优化
     * 0ms
     * */
    int[][][] rec;

    public int numTrees2(int n) {
        rec = new int[n + 1][n + 1][n + 1];
        return helper2(1, n);
    }

    private int helper2(int left, int right) {
        if (left >= right) {
            return 1;
        }
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (rec[left][i][right] != 0) {
                ans += rec[left][i][right];
            } else {
                int value = helper2(left, i - 1) * helper2(i + 1, right);
                ans += value;
                rec[left][i][right] = value;
            }
        }
        return ans;
    }

}
