package LeetCode.Medium;


import java.util.TreeSet;

public class LC_792 {

    public int numMatchingSubseq(String s, String[] words) {
        TreeSet<Integer>[] map = new TreeSet[26];
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            TreeSet<Integer> set = map[index];
            if (set == null) {
                set = new TreeSet<>();
                map[index] = set;
            }
            set.add(i);
        }
        for (String word : words) {
            char[] charArray = word.toCharArray();
            int last = -2;
            boolean flag = true;
            for (char c : charArray) {
                int index = c - 'a';
                TreeSet<Integer> set = map[index];
                if (set == null) {
                    flag = false;
                    break;
                }
                Integer ceiling = set.ceiling(last + 1);
                if (ceiling == null || ceiling <= last) {
                    flag = false;
                    break;
                }
                last = ceiling;
            }
            if (flag) ans++;
        }
        return ans;
    }
}
