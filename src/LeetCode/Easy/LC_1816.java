package LeetCode.Easy;

public class LC_1816 {
    public String truncateSentence(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
            if (count < k) {
                stringBuilder.append(s.charAt(i));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
