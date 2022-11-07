package AcWing.Chapter1;

import AcWing.util.AWUtils;

import java.util.Arrays;

/*
    ���� n ������ [li,ri]��Ҫ��ϲ������н��������䡣

    ע������ڶ˵㴦�ཻ��Ҳ���н�����

    ����ϲ���ɺ�����������

    ���磺[1,3] �� [2,6] ���Ժϲ�Ϊһ������ [1,6]��

    �����ʽ
    ��һ�а������� n��

    ������ n �У�ÿ�а����������� l �� r��

    �����ʽ
    ��һ�У�����һ����������ʾ�ϲ�������ɺ�����������

    ���ݷ�Χ
    1��n��100000,
    ?109��li��ri��109
    ����������
    5
    1 2
    2 4
    5 6
    7 8
    7 9
    ���������
    3
* */
public class AW_803 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        int[][] arr = AWUtils.intsArrayInput(n);
        int ans = combine(arr);
        System.out.println(ans);
    }

    private static int combine(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : b[1] - a[1]);
        int ans = 0, border = Integer.MIN_VALUE;
        for (int[] ints : arr) {
            if (ints[0] > border) ans++;
            border = Math.max(border, ints[1]);
        }
        return ans;
    }
}
