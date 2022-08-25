package CrackCodeInterview.XVII_Hard;

import java.util.ArrayList;
import java.util.List;

public class Interview_17_11 {
    public int findClosest(String[] words, String word1, String word2) { //记录所有出现的word1和word2
        List<Integer> rec1 = new ArrayList<>(), rec2 = new ArrayList<>();
        int ans = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                rec1.add(i);
            } else if (words[i].equals(word2)) {
                rec2.add(i);
            }
        }
        for (Integer value : rec1) {
            for (Integer integer : rec2) {
                int temp = Math.abs(integer - value);
                if (temp == 1) {
                    return temp;
                }
                ans = Math.min(temp, ans);
            }
        }
        return ans;
    }

    public int findClosest2(String[] words, String word1, String word2) { //合理的做法，双指针
        int cur1 = 0, cur2 = 0, ans = words.length;
        boolean flag1 = false, flag2 = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                cur1 = i;
                flag1 = true;
            }
            if (words[i].equals(word2)) {
                cur2 = i;
                flag2 = true;
            }
            if (flag1 && flag2) {
                ans = Math.min(ans, Math.abs(cur2 - cur1));
            }
        }
        return ans;
    }
}
