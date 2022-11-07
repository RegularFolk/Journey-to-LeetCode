package AcWing.Chapter1;

/*
    ����һ������Ϊ n ���������У����ҳ���Ĳ������ظ��������������䣬������ĳ��ȡ�

    �����ʽ
    ��һ�а������� n��

    �ڶ��а��� n ������������ 0?105 ��Χ�ڣ�����ʾ�������С�

    �����ʽ
    ��һ�У�����һ����������ʾ��Ĳ������ظ���������������ĳ��ȡ�

    ���ݷ�Χ
    1��n��105
    ����������
    5
    1 2 2 3 5
    ���������
    3
* */
import AcWing.util.AWUtils;

public class AW_799 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        int[] arr = AWUtils.intArrayInput(n);
        int ans = longestUniqueNum(arr);
        System.out.println(ans);
    }

    private static int longestUniqueNum(int[] arr) {
        boolean[] map = new boolean[100001];
        int ans = 0, l = 0, r = 0;
        while (r < arr.length) {
            while (r < arr.length && !map[arr[r]]) map[arr[r++]] = true;//�ƶ���ָ��
            ans = Math.max(r - l, ans);
            while (r < arr.length && map[arr[r]]) map[arr[l++]] = false;//�ƶ���ָ��
        }
        return ans;
    }
}
