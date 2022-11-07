package LeetCode.Medium;

public class LC_686 {
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("a", "aa"));
    }

    public static int repeatedStringMatch(String a, String b) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (!arr[b.charAt(i) - 'a']) {
                return -1;
            }
        }
        int count = b.length() / a.length();
        StringBuilder sb = new StringBuilder(a.repeat(count));
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return count + i;
            }
            sb.append(a);
        }
        return -1;
    }
}
