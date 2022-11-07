package LeetCode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC_438 {
    public static void main(String[] args) {
        List<Integer> list = findAnagrams2("cbaebabacd", "abc");
        System.out.println(list);
    }

    public static List<Integer> findAnagrams(String s, String p) {  //���û�������
        List<Integer> ans = new LinkedList<>();
        int sLen = s.length();
        int pLen = p.length();
        int[] key = new int[26];
        int[] win = new int[26];
        if (sLen < pLen) {
            return ans;
        }
        for (int i = 0; i < pLen; i++) {  //������ʼ����
            key[p.charAt(i) - 'a']++;
            win[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(key, win)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            win[s.charAt(i) - 'a']--;
            win[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(key, win)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static List<Integer> findAnagrams2(String s, String p) {  //�Ż��������ڣ����ô�Ƶ�������
        //"cbaebabacd", "abc"
        List<Integer> ans = new LinkedList<>();
        int sLen = s.length();
        int pLen = p.length();
        int diff = 0;
        if (sLen < pLen) {
            return ans;
        }
        int[] frequency = new int[26];
        for (int i = 0; i < pLen; i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[p.charAt(i) - 'a']--;
        }
        for (Integer num : frequency) {
            if (num != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            int left = s.charAt(i) - 'a';
            int right = s.charAt(i + pLen) - 'a';
            frequency[left]--;
            if (frequency[left] == 0) {
                diff--;
            } else if (frequency[left] == -1) {
                diff++;
            }
            frequency[right]++;  //������ȼ����ټӻ�ȥ
            if (frequency[right] == 0) {
                diff--;
            } else if (frequency[right] == 1) {
                diff++;
            }
            if (diff == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
