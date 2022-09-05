package Easy;

public class LC_796 {
    /*
     * 把每一位作为旋转位后比较
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
