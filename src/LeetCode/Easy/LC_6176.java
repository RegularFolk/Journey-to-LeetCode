package LeetCode.Easy;

import org.junit.Test;

import java.util.Arrays;

public class LC_6176 {
    /*
     * 对s建表，再与distance比对
     * */
    public boolean checkDistances(String s, int[] distance) {
        int[] dic = new int[26];
        Arrays.fill(dic, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (dic[index] != -1) {
                dic[index] = i - dic[index] - 1;
            } else {
                dic[index] = i;
            }
        }
        for (int i = 0; i < dic.length; i++) {
            if (dic[i] != -1 && dic[i] != distance[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void x(){
        boolean abaccb = checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        System.out.println(abaccb);
    }
}
