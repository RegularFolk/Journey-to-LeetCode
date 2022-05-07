package Easy;

public class LC_520 {
    public static void main(String[] args) {

    }

    public static boolean detectCapitalUse(String word) {
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            for (int i = 2; i < word.length(); i++) {
                if ((word.charAt(i - 1) >= 'A' && word.charAt(i - 1) <= 'Z' && word.charAt(i) >= 'a' && word.charAt(i) <= 'z') ||
                        (word.charAt(i - 1) >= 'a' && word.charAt(i - 1) <= 'z' && word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }
}
