package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LC_816 {
    /*
     * ���������
     * */
    public List<String> ambiguousCoordinates(String s) {
        String realS = s.substring(1, s.length() - 1);
        return separate(realS);
    }

    //��ԭ�ַ������
    private List<String> separate(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            List<String> pos1 = format(s.substring(0, i + 1));
            List<String> pos2 = new ArrayList<>();
            if (!pos1.isEmpty()) pos2 = format(s.substring(i + 1));
            if (!pos1.isEmpty() && !pos2.isEmpty()) addToAns(pos1, pos2, ans);
        }
        return ans;
    }

    //����һ���ַ������������ܵĺϷ����
    private List<String> format(String s) {
        List<String> pos = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = s.substring(0, i + 1);
            String s2 = s.substring(i + 1);
            if (legal(s1) && legal(new StringBuilder(s2).reverse().toString())) {
                if (s2.charAt(s2.length() - 1) != '0')//��ֹs2ֻ��һ��0�����
                    pos.add(s1 + "." + s2);
            }
        }
        if (legal(s)) pos.add(s);//�������С���㣬����Ϸ�����
        return pos;
    }

    //С����ǰ��Ĺ������෴�ģ��������ֲ�����ͷ�㣬С�����ֲ������β0����תС�����֣�ͳһ�жϿ�ͷ��
    private boolean legal(String s) {
        return s.length() == 1 || s.charAt(0) != '0';
    }

    private void addToAns(List<String> pos1, List<String> pos2, List<String> ans) {
        pos1.forEach(s1 -> pos2.forEach(s2 -> ans.add("(" + s1 + ", " + s2 + ")")));
    }
}
