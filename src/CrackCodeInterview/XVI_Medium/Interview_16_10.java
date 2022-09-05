package CrackCodeInterview.XVI_Medium;

import java.util.Arrays;

public class Interview_16_10 {
    /*
     * ������ָ�룬����������������
     * ����ϳ��������³�����¼����������ʱ��
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
     * ����Ͱ��������¼ÿһ��ĳ������������ֻ���ǳ�����ݣ���Ϊ�������ֻ������ڳ������
     * ע�������ĳһ����������Ӧ���ں�һ�걻����
     * */
    public int maxAliveYear2(int[] birth, int[] death) {
        int[] years = new int[101];
        int maxYear = 0, max = 0, current = 0;
        for (int i = 0; i < birth.length; i++) {
            years[birth[i] - 1900]++;
            if (death[i] <= 1999) {
                years[death[i] - 1899]--;
            }
        }//����ݽ��з���
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
