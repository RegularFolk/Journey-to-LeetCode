package CrackCodeInterview.XVI_Medium;

import java.util.Arrays;

public class Interview_16_10 {
    /*
     * 用两个指针，排序后遍历两个数组
     * 活的上车，死了下车，记录车上人最多的时候
     * */
    public int maxAliveYear1(int[] birth, int[] death) {
        int maxYear = 0, max = 0, current = 0;
        int curYear = 0, curDeath = 0;
        Arrays.sort(birth);
        Arrays.sort(death);
        while (curYear < birth.length || curDeath < death.length) {
            if (curYear < birth.length && birth[curYear] <= death[curDeath]) {
                current++;
                if (current > max) {
                    max = current;
                    maxYear = birth[curYear];
                }
                curYear++;
            } else {
                current--;
                curDeath++;
            }
        }
        return maxYear;
    }

    /*
     * 利用桶计数，记录每一年的出生死亡情况，只考虑出生年份，因为最多人数只会出现在出生年份
     * 注意的是在某一年死亡的人应该在后一年被减掉
     * */
    public int maxAliveYear2(int[] birth, int[] death) {
        int[] years = new int[101];
        int maxYear = 0, max = 0, current = 0;
        for (int i = 0; i < birth.length; i++) {
            years[birth[i] - 1900]++;
            if (death[i] <= 1999) {
                years[death[i] - 1899]--;
            }
        }//对年份进行分析
        for (int i = 0; i < years.length; i++) {
            current += years[i];
            if (current > max) {
                max = current;
                maxYear = i + 1900;
            }
        }
        return maxYear;
    }
}
