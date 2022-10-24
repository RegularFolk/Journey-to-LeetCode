package AcWing.Chapter1;

/*
    给定一个浮点数 n，求它的三次方根。

    输入格式
    共一行，包含一个浮点数 n。

    输出格式
    共一行，包含一个浮点数，表示问题的解。

    注意，结果保留 6 位小数。

    数据范围
    ?10000≤n≤10000
    输入样例：
    1000.00
    输出样例：
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
