package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ�������������еĳ���Ϊ n ���������飬�Լ� q ����ѯ��

    ����ÿ����ѯ������һ��Ԫ�� k ����ʼλ�ú���ֹλ�ã�λ�ô� 0 ��ʼ��������

    ��������в����ڸ�Ԫ�أ��򷵻� -1 -1��

    �����ʽ
    ��һ�а������� n �� q����ʾ���鳤�Ⱥ�ѯ�ʸ�����

    �ڶ��а��� n ������������ 1?10000 ��Χ�ڣ�����ʾ�������顣

    ������ q �У�ÿ�а���һ������ k����ʾһ��ѯ��Ԫ�ء�

    �����ʽ
    �� q �У�ÿ�а���������������ʾ����Ԫ�ص���ʼλ�ú���ֹλ�á�

    ��������в����ڸ�Ԫ�أ��򷵻� -1 -1��

    ���ݷ�Χ
    1��n��100000
    1��q��10000
    1��k��10000
    ����������
    6 3
    1 2 2 3 3 4
    3
    4
    5
    ���������
    3 4
    5 5
    -1 -1
* */
public class AW_789 {

    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], q = ints[1];
        int[] arr = AWUtils.intArrayInput(n);
        int[] queries = AWUtils.intsInputLineByLine(q);
        int[][] ans = new int[q][2];
        for (int i = 0; i < queries.length; i++) {
            ans[i][0] = findLeft(arr, queries[i]);
            ans[i][1] = findRight(arr, queries[i]);
        }
        AWUtils.printDoubleArray(ans);
    }

    private static int findRight(int[] arr, int query) {
        int l = 0, r = arr.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] <= query) {
                if (arr[mid] == query) pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }

    private static int findLeft(int[] arr, int query) {
        int l = 0, r = arr.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] < query) {
                l = mid + 1;
            } else {
                if (arr[mid] == query) pos = mid;
                r = mid - 1;
            }
        }
        return pos;
    }

}
