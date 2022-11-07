package LeetCode.Hard;

import java.util.Arrays;

public class LC_828_mark {
    /*
     *  两重模拟超时
     * */
    public int uniqueLetterString1(String s) {
        int ans = 0;
        for (int k = 0; k < s.length(); k++) {
            for (int i = 0; i + k < s.length(); i++) {
                ans += count(s.substring(i, i + k + 1));
            }
        }
        return ans;
    }

    private int count(String substring) {
        int[] rec = new int[26];
        for (int i = 0; i < substring.length(); i++) {
            rec[substring.charAt(i) - 'A']++;
        }
        int ans = 0;
        for (int i : rec) {
            if (i == 1) ans++;
        }
        return ans;
    }

    /*
    * 计算每个字符对答案的>>贡献度<<
    * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/solution/tong-ji-zi-chuan-zhong-de-wei-yi-zi-fu-b-ajio/
    * 妙
    * */
    public int uniqueLetterString2(String s) {
        //存储last字符前一个字符所在位置
        int[] lastIndexMap = new int[26];
        //存储cur字符当前所处位置
        int[] curIndexMap = new int[26];
        Arrays.fill(lastIndexMap, -1);
        Arrays.fill(curIndexMap, -1);
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            //next字符
            int index = chars[i] - 'A';
            //cur字符的索引不是-1，计算cur字符的贡献值
            if (curIndexMap[index] > -1) {
                ans += (i - curIndexMap[index]) * (curIndexMap[index] - lastIndexMap[index]);
            }
            //滚动存放cur和last
            lastIndexMap[index] = curIndexMap[index];
            curIndexMap[index] = i;
        }
        //计算最后next字符的贡献值，最后一个位置就是s.length()
        for (int i = 0; i < 26; i++) {
            if (curIndexMap[i] > -1) {
                ans += (curIndexMap[i] - lastIndexMap[i]) * (s.length() - curIndexMap[i]);
            }
        }
        return ans;
    }
}
