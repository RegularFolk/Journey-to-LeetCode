package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC_1177 {

    /*
     * 判断是否可以组成回文串的方法：
     *   如果字符串长度为偶数，则其中每个字符出现偶数次
     *   如果字符串长度为奇数，则其中一个字符出现奇数次
     * 拿到一个字符串，判断其中有几个字符不合规(几个奇数)
     * 如果多了偶数个奇数，可以用数量一半的K消掉
     * 如果多了奇数个，消不掉
     * 超时（n^2）
     * */
    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
        return Arrays.stream(queries).map(q -> {
            String substring = s.substring(q[0], q[1] + 1);
            char[] chars = substring.toCharArray();
            int[] map = new int[27];
            for (char c : chars) {
                map[c - 'a']++;
            }
            int cnt = 0;
            for (int i : map) {
                if ((i & 1) == 1) {
                    cnt++;
                }
            }
            if ((substring.length() & 1) == 1) {
                cnt--;
            }
            return !((cnt & 1) == 1 || cnt >> 1 > q[2]);
        }).collect(Collectors.toList());
    }

    /*
    * 优化
    *   利用前缀和
    * 需要快速判断一个区间内字符的奇偶情况
    *
    * */
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries){

        return null;
    }
}
