package LeetCode.Hard;

import java.util.Arrays;

public class LC_828_mark {
    /*
     *  ����ģ�ⳬʱ
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
    * ����ÿ���ַ��Դ𰸵�>>���׶�<<
    * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/solution/tong-ji-zi-chuan-zhong-de-wei-yi-zi-fu-b-ajio/
    * ��
    * */
    public int uniqueLetterString2(String s) {
        //�洢last�ַ�ǰһ���ַ�����λ��
        int[] lastIndexMap = new int[26];
        //�洢cur�ַ���ǰ����λ��
        int[] curIndexMap = new int[26];
        Arrays.fill(lastIndexMap, -1);
        Arrays.fill(curIndexMap, -1);
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            //next�ַ�
            int index = chars[i] - 'A';
            //cur�ַ�����������-1������cur�ַ��Ĺ���ֵ
            if (curIndexMap[index] > -1) {
                ans += (i - curIndexMap[index]) * (curIndexMap[index] - lastIndexMap[index]);
            }
            //�������cur��last
            lastIndexMap[index] = curIndexMap[index];
            curIndexMap[index] = i;
        }
        //�������next�ַ��Ĺ���ֵ�����һ��λ�þ���s.length()
        for (int i = 0; i < 26; i++) {
            if (curIndexMap[i] > -1) {
                ans += (curIndexMap[i] - lastIndexMap[i]) * (s.length() - curIndexMap[i]);
            }
        }
        return ans;
    }
}
