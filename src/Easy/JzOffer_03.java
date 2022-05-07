package Easy;

import java.util.Scanner;

public class JzOffer_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] compare = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            compare[nums[i]]++;
            if (compare[nums[i]] > 1) {
                ans = nums[i];
                break;
            }
        }
        System.out.println(ans);
    }
}
