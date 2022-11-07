package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.Stack;

/*
    ����һ������Ϊ N ���������У����ÿ������ߵ�һ������С�������������������� ?1��

    �����ʽ
    ��һ�а������� N����ʾ���г��ȡ�

    �ڶ��а��� N ����������ʾ�������С�

    �����ʽ
    ��һ�У����� N �����������е� i ������ʾ�� i ��������ߵ�һ������С�������������������� ?1��

    ���ݷ�Χ
    1��N��105
    1��������Ԫ�ء�109
    ����������
    5
    3 4 2 7 5
    ���������
    -1 3 -1 2 2
* */
public class AW_803 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        int[] arr = AWUtils.intArrayInput(n);
        int[] ans = fistSmaller(arr);
        AWUtils.printArrayInline(ans);
    }

    //��������ջ��ֱ�Ӵ�ֵ
    private static int[] fistSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                ans[i] = -1;
            } else if (stack.peek() < arr[i]) {
                ans[i] = stack.peek();
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
                if (!stack.isEmpty()) ans[i] = stack.peek();
                else ans[i] = -1;
                stack.push(arr[i]);
            }
        }
        return ans;
    }
}
