package Medium;

public class LC_1881 {
    /*
     * ģ��
     * ���nΪ������������ڴ������ҵ�һ��С��x����֮ǰ
     * ���nΪ������������ڴ������ҵ�һ������x����֮ǰ
     * */
    public String maxValue(String n, int x) {
        boolean positive = n.charAt(0) == '-';
        if (positive) {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) - '0' < x) return n.substring(0, i) + x + n.substring(i);
            }
        } else {
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) - '0' > x) return "-" + n.substring(1, i) + x + n.substring(i);
            }
        }
        return n + x;
    }
}
