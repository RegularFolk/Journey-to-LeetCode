package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ������Ϊ n �����У��������������ÿ�����Ķ����Ʊ�ʾ�� 1 �ĸ�����

    �����ʽ
    ��һ�а������� n��

    �ڶ��а��� n ����������ʾ�������С�

    �����ʽ
    ��һ�У����� n �����������еĵ� i ������ʾ�����еĵ� i �����Ķ����Ʊ�ʾ�� 1 �ĸ�����

    ���ݷ�Χ
    1��n��100000,
    0��������Ԫ�ص�ֵ��109
    ����������
    5
    1 2 3 4 5
    ���������
    1 1 2 1 2
* */
public class AW_801 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        int[] arr = AWUtils.intArrayInput(n);
        int[] ans = count1(arr);
        AWUtils.printArrayInline(ans);
    }

    private static int[] count1(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            while (arr[i] > 0) {
                count += arr[i] & 1;
                arr[i] >>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }
}
