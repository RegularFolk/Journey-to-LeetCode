package NoteBook.SearchAlgorithm;

import java.util.Scanner;

public class PrimeNumberSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n + 1];
        if (n >= 2) {
            for (int i = 1; i <= getPrime(n, ans); i++) {
                System.out.println(ans[i]);
            }
        } else {
            System.out.println("无");
        }
    }

    public static int getPrime(int n, int[] ans) {
        int count = 0;
        boolean[] judge = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!judge[i]) {
                ans[++count] = i;
                for (int j = 2; j * i <= n; j++) {
                    if (!judge[j * i]) {
                        judge[j * i] = true;
                    }
                }
            }
        }
        return count;
    }
}
