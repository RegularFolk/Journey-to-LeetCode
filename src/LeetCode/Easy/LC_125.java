package LeetCode.Easy;

public class LC_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        do {
            while ((left < s.length()) && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }
            while ((right >= 0) && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            if (right < 0 || left > s.length() - 1) {
                break;
            }
        } while (s.charAt(left++) == s.charAt(right--));
        return left == s.length() && right == -1;
    }

    public static boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        StringBuilder front = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isDigit(temp) || Character.isLetter(temp)) {
                front.append(temp);
            }
        }
        StringBuilder backward = new StringBuilder(front).reverse();
        return front.compareTo(backward) == 0;
    }
}
