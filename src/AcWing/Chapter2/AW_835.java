package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.ArrayList;

/*
    ά��һ���ַ������ϣ�֧�����ֲ�����

    I x �򼯺��в���һ���ַ��� x��
    Q x ѯ��һ���ַ����ڼ����г����˶��ٴΡ�
    ���� N ��������������ַ����ܳ��Ȳ����� 105���ַ���������СдӢ����ĸ��

    �����ʽ
    ��һ�а������� N����ʾ��������

    ������ N �У�ÿ�а���һ������ָ�ָ��Ϊ I x �� Q x �е�һ�֡�

    �����ʽ
    ����ÿ��ѯ��ָ�� Q x����Ҫ���һ��������Ϊ�������ʾ x �ڼ����г��ֵĴ�����

    ÿ�����ռһ�С�

    ���ݷ�Χ
    1��N��2*104
    ����������
    5
    I abc
    Q abc
    Q ab
    I ab
    Q ab
    ���������
    1
    0
    1
* */
public class AW_835 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        String[] s = AWUtils.stringArrayInput(n);
        ArrayList<Integer> ans = tire(s);
        AWUtils.printListByLine(ans);
    }

    private static ArrayList<Integer> tire(String[] s) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (String s1 : s) {
            if (s1.startsWith("Q")) {
                ans.add(query(s1.substring(2).toCharArray()));
            } else {
                insert(s1.substring(2).toCharArray());
            }
        }
        return ans;
    }

    private static int idx = 0;  //idx��ȥ�����ýڵ�һ�������˼���
    private static final int n = 100010;  //n��ʾ����������ַ����ܳ���
    private static final int[][] son = new int[n][26];//�ö�ά����ģ�����νṹ��ע��������Ľṹ�����⣬������֮�䲻�Ƕ����
    private static final int[] cnt = new int[n];

    private static Integer query(char[] string) {
        int last = 0;  //���ϼ�¼��ѯ������·��ĩβ�Ľڵ�
        for (char c : string) {
            int index = c - 'a';
            if (son[last][index] == 0) return 0;//���ҹ����ж��ˣ�˵��������
            last = son[last][index];
        }
        return cnt[last];
    }

    private static void insert(char[] string) {
        int last = 0;
        for (char c : string) {
            int index = c - 'a';
            if (son[last][index] == 0) son[last][index] = ++idx;//���Ϊ0˵����һ���µķ�֧����Ϊ0˵��ԭ���Ѿ����ˣ������������������
            last = son[last][index];
        }
        cnt[last]++;
    }
}
