package Easy;

public class LC_459 {
    /*
     * �����Ƚ�
     * n^2
     * ����80
     * */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length() / 2;
        for (int i = 1; i <= len; i++) {
            if (s.length() % i != 0) {//��֦
                if (s.substring(0, i).repeat(s.length() / i).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
