package LeetCode.Easy;

import java.util.Scanner;

public class LC_1614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {//甚至都不用真的做栈
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp++;
            } else if (s.charAt(i) == ')') {
                temp--;
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
