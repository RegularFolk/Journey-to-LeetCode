package Easy;


import java.util.Scanner;

public class LC_496 {
    public static void main(String[] args) {//Unsolved
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] nums1 = new int[n1];
        int[] nums2 = new int[n2];
        for (int i : nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int mark = 0;
        int count = 0;
        int[] output = new int[nums1.length];
        System.arraycopy(nums1, 0, output, 0, nums1.length);
        for (int i : nums2) {
            for (int j : nums1) {
                if (i == j) {
                    break;
                }
            }
            mark++;
        }
        for (int i = mark + 1; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (output[j] == nums1[j] && nums2[i] > output[j]) {
                    output[j] = nums2[i];
                    count++;
                }
            }
            if (count == nums1.length) {
                break;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (output[i] == nums1[i]) {
                output[i] = -1;
            }
        }
        return output;
    }
}
