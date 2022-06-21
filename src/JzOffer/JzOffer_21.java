package JzOffer;

import java.util.Scanner;
/*
典型的双指针
*/
public class JzOffer_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int low = 0;
        int high = nums.length - 1;
        int temp ;
        while (high >= low) {
            if (nums[high] % 2 == 1) {
                for (; low <= high; low++) {
                    if (nums[low] % 2 == 0) {
                        temp = nums[low];
                        nums[low] = nums[high];
                        nums[high] = temp;
                        break;
                    }
                }
            }
            high--;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
