package Easy;

public class LC_796 {
    /*
     * ��ÿһλ��Ϊ��תλ��Ƚ�
     * */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                String rotate = s.substring(i) + s.substring(0, i);
                if (rotate.equals(goal)) return true;
            }
        }
        return false;
    }
}
