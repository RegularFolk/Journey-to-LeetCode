package AcWing.Chapter1;

/*
    ����һ�������� n�����������η�����

    �����ʽ
    ��һ�У�����һ�������� n��

    �����ʽ
    ��һ�У�����һ������������ʾ����Ľ⡣

    ע�⣬������� 6 λС����

    ���ݷ�Χ
    ?10000��n��10000
    ����������
    1000.00
    ���������
    10.000000
* */

import AcWing.util.AWUtils;

public class AW_790 {
    public static void main(String[] args) {
        double n = AWUtils.doubleInput();
        double ans = cubeSquare(n);
        System.out.printf("%.6f\n", ans);
    }

    private static double cubeSquare(double n) {
        double l = -10000, r = 10000;
        while (r - l > 1e-8) {
            double mid = (l + r) / 2;
            double triple = mid * mid * mid;
            if (triple > n) r = mid;
            else l = mid;
        }
        return l;
    }
}
