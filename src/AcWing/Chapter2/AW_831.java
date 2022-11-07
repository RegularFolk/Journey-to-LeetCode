package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.ArrayList;

/*
    ����һ���ַ��� S���Լ�һ��ģʽ�� P�������ַ�����ֻ������СдӢ����ĸ�Լ����������֡�

    ģʽ�� P ���ַ��� S �ж����Ϊ�Ӵ����֡�

    ���ģʽ�� P ���ַ��� S �����г��ֵ�λ�õ���ʼ�±ꡣ

    �����ʽ
    ��һ���������� N����ʾ�ַ��� P �ĳ��ȡ�

    �ڶ��������ַ��� P��

    �������������� M����ʾ�ַ��� S �ĳ��ȡ�

    �����������ַ��� S��

    �����ʽ
    ��һ�У�������г���λ�õ���ʼ�±꣨�±�� 0 ��ʼ������������֮���ÿո������

    ���ݷ�Χ
    1��N��105
    1��M��106
    ����������
    3
    aba
    5
    ababa
    ���������
    0 2
* */
public class AW_831 {
    public static void main(String[] args) {
        AWUtils.intInput();
        String p = AWUtils.stringInput();
        AWUtils.intsInput();
        String s = AWUtils.stringInput();
        ArrayList<Integer> ans = kmp((" " + p).toCharArray(), (" " + s).toCharArray());
        AWUtils.printListInLint(ans);
    }

    private static ArrayList<Integer> kmp(char[] p, char[] s) {
        int[] next = getNext(p);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1, j = 0; i < s.length; i++) {
            while (j != 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == p.length - 1) {
                ans.add(i - p.length + 1);
                j = next[j];
            }
        }
        return ans;
    }

    /*
     * next����Ķ���:next[i]Ϊ�±�0~i���Ӵ����ͬǰ��׺�ĳ���
     * */
    private static int[] getNext(char[] p) {
        int[] next = new int[p.length];
        for (int curNext = 2, curP = 0; curNext < p.length; curNext++) {
            while (curP != 0 && p[curNext] != p[curP + 1]) curP = next[curP];
            if (p[curNext] == p[curP + 1]) curP++;
            next[curNext] = curP;
        }
        return next;
    }
}
