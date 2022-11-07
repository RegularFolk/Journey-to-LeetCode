package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.LinkedList;
/*
    ����һ����СΪ n��106 �����顣

    ��һ����СΪ k �Ļ������ڣ����������������ƶ������ұߡ�

    ��ֻ���ڴ����п��� k �����֡�

    ÿ�λ������������ƶ�һ��λ�á�

    ������һ�����ӣ�

    ������Ϊ [1 3 -1 -3 5 3 6 7]��k Ϊ 3��

    ����λ��	��Сֵ	���ֵ
    [1 3 -1] -3 5 3 6 7	-1	3
    1 [3 -1 -3] 5 3 6 7	-3	3
    1 3 [-1 -3 5] 3 6 7	-3	5
    1 3 -1 [-3 5 3] 6 7	-3	5
    1 3 -1 -3 [5 3 6] 7	3	6
    1 3 -1 -3 5 [3 6 7]	3	7
    ���������ȷ����������λ��ÿ��λ��ʱ�������е����ֵ����Сֵ��

    �����ʽ
    ����������С�

    ��һ�а����������� n �� k���ֱ�������鳤�Ⱥͻ������ڵĳ��ȡ�

    �ڶ����� n ����������������ľ�����ֵ��

    ͬ������֮���ÿո������

    �����ʽ
    �������������

    ��һ��������������ң�ÿ��λ�û��������е���Сֵ��

    �ڶ���������������ң�ÿ��λ�û��������е����ֵ��

    ����������
    8 3
    1 3 -1 -3 5 3 6 7
    ���������
    -1 -3 -3 -3 3 3
    3 3 5 5 6 7
* */
public class AW_154 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], k = ints[1];
        int[] arr = AWUtils.intArrayInput(n);
        int[][] ans = slidingWid(arr, k);
        AWUtils.printArrayInline(ans[0]);
        System.out.println();
        AWUtils.printArrayInline(ans[1]);
    }

    //����������������
    private static int[][] slidingWid(int[] arr, int k) {
        int wins = arr.length - k + 1;
        int[][] ans = new int[2][wins];
        LinkedList<Integer> big = new LinkedList<>();
        LinkedList<Integer> small = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!big.isEmpty() && arr[big.getLast()] < arr[i]) big.removeLast();
            big.addLast(i);
            while (!small.isEmpty() && arr[small.getLast()] > arr[i]) small.removeLast();
            small.addLast(i);
        }
        for (int i = 0; i < wins; i++) {
            int index = i + k - 1;
            while (!big.isEmpty() && arr[big.getLast()] < arr[index]) big.removeLast();
            big.addLast(index);
            while (!small.isEmpty() && arr[small.getLast()] > arr[index]) small.removeLast();
            small.addLast(index);
            ans[0][i] = arr[small.getFirst()];
            ans[1][i] = arr[big.getFirst()];
            if (big.getFirst() == i) big.removeFirst();
            if (small.getFirst() == i) small.removeFirst();
        }
        return ans;
    }
}
