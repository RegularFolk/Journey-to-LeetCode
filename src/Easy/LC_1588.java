package Easy;

import java.util.Scanner;

public class LC_1588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i <= arr.length; i = i + 2) {
            for (int start = 0, end = start + i - 1; end < arr.length; start++, end++) {
                for (int j = start; j <= end; j++) {
                    ans += arr[j];
                }
            }
        }
        System.out.println(ans);
    }
}
