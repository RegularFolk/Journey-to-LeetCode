package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ������Ϊ n ���������� a1,a2,��,an �Լ�һ������Ϊ m ���������� b1,b2,��,bm��

    �����ж� a �����Ƿ�Ϊ b ���е������С�

    ������ָ���е�һ�����ԭ�д������ж��õ����У��������� {a1,a3,a5} ������ {a1,a2,a3,a4,a5} ��һ�������С�

    �����ʽ
    ��һ�а����������� n,m��

    �ڶ��а��� n ����������ʾ a1,a2,��,an��

    �����а��� m ����������ʾ b1,b2,��,bm��

    �����ʽ
    ��� a ������ b ���е������У����һ�� Yes��

    ������� No��

    ���ݷ�Χ
    1��n��m��105,
    ?109��ai,bi��109
    ����������
    3 5
    1 3 5
    1 2 3 4 5
    ���������
    Yes
* */
public class AW_2816 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], m = ints[1];
        int[] a = AWUtils.intArrayInput(n);
        int[] b = AWUtils.intArrayInput(m);
        boolean ans = subSequence(a, b);
        System.out.println(ans ? "Yes" : "No");
    }

    private static boolean subSequence(int[] a, int[] b) {
        int c1 = 0, c2 = 0;
        while (c1 < a.length && c2 < b.length) {
            if (a[c1] == b[c2]) c1++;
            c2++;
        }
        return c1 == a.length;
    }
}
