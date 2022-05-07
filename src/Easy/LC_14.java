package Easy;

import java.util.Scanner;

public class LC_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = new String[n];
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }
        int minLen = s[0].length();
        for (int i = 1; i < n; i++) {
            minLen = Math.min(minLen, s[i].length());
        }
        for (int i = 0; i < minLen; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                if (s[j].charAt(i) != s[j + 1].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                ans.append(s[0].charAt(i));
            }
        }
        System.out.println(ans);
    }
}
