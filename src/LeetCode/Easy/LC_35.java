package LeetCode.Easy;

import java.util.Scanner;

public class LC_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        boolean flag = true;
        int ans = 0;
        for (int low = 0, high = n - 1; high >= low; ) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                flag = false;
                ans = mid;
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        if (flag) {
            if (target < nums[0]) {
                ans = 0;
            } else if (target > nums[n - 1]) {
                ans = n;
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if ((nums[i] < target) & (nums[i + 1] > target)) {
                        ans = i + 1;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}