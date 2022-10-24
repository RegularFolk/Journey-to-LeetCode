package Leet.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC_6183 {
    /*
     * ɢ�б�
     * ��ʱ
     * ����˼·:
     *  map��¼һ�����ϣ�keyΪprefix��������Ԫ�ر�ʾ���prefix���ܷ֣�����֮�����words�������prefix��ͷ���ַ������±꣬���ڿ����ж�prefix+1��ǰ׺
     *  �����ڴ�����
     * */
    public int[] sumPrefixScores(String[] words) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] += getScore(words, words[i], map);
        }
        return ans;
    }

    /*
     * ��ȡprefix���ܷ�
     * */
    private Integer getScore(String[] words, String prefix, Map<String, ArrayList<Integer>> map) {
        ArrayList<Integer> rec = map.getOrDefault(prefix, null);
        if (rec == null) rec = count(words, prefix, map);
        return rec.get(0);
    }

    private ArrayList<Integer> count(String[] words, String prefix, Map<String, ArrayList<Integer>> map) {
        if (prefix == null || prefix.length() == 0) return null;
        ArrayList<Integer> mapValue = map.getOrDefault(prefix, null);
        if (mapValue != null) return mapValue;
        String prevSub = prefix.substring(0, prefix.length() - 1);
        ArrayList<Integer> prev = map.getOrDefault(prevSub, null);
        ArrayList<Integer> cur = new ArrayList<>();
        cur.add(0);
        if (prev == null) prev = count(words, prevSub, map);
        if (prev != null) {
            cur.set(0, prev.get(0));
            for (int i = 1; i < prev.size(); i++) {
                if (words[prev.get(i)].length() >= prefix.length()) {
                    if (words[prev.get(i)].charAt(prefix.length() - 1) == prefix.charAt(prefix.length() - 1)) {
                        cur.add(prev.get(i));
                        cur.set(0, cur.get(0) + 1);
                    }
                }
            }
        } else {//��ǰprefix����Ϊ1
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(prefix)) {
                    cur.set(0, cur.get(0) + 1);
                    cur.add(i);
                }
            }
        }
        map.put(prefix, cur);
        return cur;
    }
}
