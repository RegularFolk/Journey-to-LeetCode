package Medium;

import java.util.LinkedList;
import java.util.List;

public class LC_763 {
    /*
     * 统计每一个字符出现的最远边界
     * */
    public List<Integer> partitionLabels(String s) {
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int curMax = 0, left = 0;
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            curMax = Math.max(curMax, edge[index]);
            if (curMax == i) {
                ans.add(curMax - left + 1);
                left = i + 1;
            }
        }
        return ans;
    }
}
