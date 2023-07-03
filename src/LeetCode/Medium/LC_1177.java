package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC_1177 {

    /*
     * �ж��Ƿ������ɻ��Ĵ��ķ�����
     *   ����ַ�������Ϊż����������ÿ���ַ�����ż����
     *   ����ַ�������Ϊ������������һ���ַ�����������
     * �õ�һ���ַ������ж������м����ַ����Ϲ�(��������)
     * �������ż��������������������һ���K����
     * ���������������������
     * ��ʱ��n^2��
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
    * �Ż�
    *   ����ǰ׺��
    * ��Ҫ�����ж�һ���������ַ�����ż���
    *
    * */
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries){

        return null;
    }
}
