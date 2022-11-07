package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ������Ϊ n ���������С�

    ������������ m ��ѯ�ʣ�ÿ��ѯ������һ�� l,r��

    ����ÿ��ѯ�ʣ����ԭ�����дӵ� l �������� r �����ĺ͡�

    �����ʽ
    ��һ�а����������� n �� m��

    �ڶ��а��� n ����������ʾ�������С�

    ������ m �У�ÿ�а����������� l �� r����ʾһ��ѯ�ʵ����䷶Χ��

    �����ʽ
    �� m �У�ÿ�����һ��ѯ�ʵĽ����

    ���ݷ�Χ
    1��l��r��n,
    1��n,m��100000,
    ?1000��������Ԫ�ص�ֵ��1000
    ����������
    5 3
    2 1 3 6 4
    1 2
    1 3
    2 4
    ���������
    3
    6
    10
* */
public class AW_795 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], m = ints[1];
        int[] arr = AWUtils.intArrayInput(n);
        int[][] queries = AWUtils.intsArrayInput(m);
        int[] ans = preSum(arr, queries);
        AWUtils.printArrayByLine(ans);
    }

    private static int[] preSum(int[] arr, int[][] queries) {
        int[] preArr = getPreArr(arr);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = preArr[queries[i][1] - 1] -(queries[i][0] - 2 == -1 ? 0 : preArr[queries[i][0] - 2]);
        }
        return ans;
    }

    //����ǰ׺������
    private static int[] getPreArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
    }
}
