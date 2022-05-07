package Easy;

import java.util.Scanner;
/*
双指针
快指针 cursor 不断往前移，每次找到不等于 val 的值就依次摆在慢指针 ans 的位置上
*/
public class LC_27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int val = sc.nextInt();
        int cursor = 0;
        int ans = 0;
        while (cursor < nums.length) {
            if (nums[cursor] != val) {
                nums[ans] = nums[cursor];
                ans++;
            }
            cursor++;
        }
        System.out.println(ans);
    }
}
