package Leet.Medium;

import java.util.ArrayList;

public class LC_6202 {
    /*
    * ��
    * ����˼·����ÿ���ַ�ͳ�����С����ĸ���������Щ�������ַ�����֮ǰ���䲻����
    * �鷳�ĵط������ߵ�һ���ַ���Դ�ǰ��״̬�ĸ���
    * */
    public String robotWithString(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[chars.length];
        int[] alpha = new int[26];
        int[] limit = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            alpha[chars[i] - 'a']++;
            limit[i] = getLimit(chars[i], alpha);
        }
        ArrayList<Integer> stack = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (limit[i] != 0) stack.add(i);
            else {
                builder.append(chars[i]);
                //TODO
            }
        }
        return builder.toString();
    }

    private int getLimit(char aChar, int[] alpha) {
        int count = 0;
        for (int i = aChar - 'a'; i < aChar; i++) {
            count += alpha[i];
        }
        return count;
    }
}
