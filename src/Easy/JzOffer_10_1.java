package Easy;

import java.util.Scanner;

public class JzOffer_10_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.println("第： " + i + " 项为: " + fibo(i));
        }
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        } else if (n >= 47) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
