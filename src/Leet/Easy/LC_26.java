package Leet.Easy;

import java.util.Scanner;

/*
经典双指针
*/

public class LC_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = 0;
        int next = 1;
        int cursor = 1;
        while (next < nums.length) {
            if (nums[next] > nums[ans]) {
                ans++;
                next++;
            } else {
                boolean flag = true;
                while (cursor < nums.length) {
                    if (nums[cursor] > nums[ans]) {
                        nums[next] = nums[cursor];
                        flag = false;
                        ans++;
                        next++;
                        break;
                    } else {
                        cursor++;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        System.out.println(ans + 1);
    }
}
