package Leet.Easy;

import java.util.Scanner;

public class LC_1646 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        int ans = 1;
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[(i - 1) / 2] + nums[(i - 1) / 2 + 1];
            }
            ans = Math.max(ans, nums[i]);
        }
        if (n == 0) {
            ans = 0;
        }
        System.out.println(ans);
    }
}
