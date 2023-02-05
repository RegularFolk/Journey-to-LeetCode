package LeetCode.Easy;

public class LC_2351 {
    /*
     * ����26λbitmap��¼���ִ���
     * */
    public char repeatedCharacter(String s) {
        int mark = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int offset = c - 'a';
            if (((mark >> offset) & 1) == 1) return c;
            mark |= 1 << offset;
        }
        throw new RuntimeException();
    }
}
