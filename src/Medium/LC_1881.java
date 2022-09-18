package Medium;

public class LC_1881 {
    /*
     * 模拟
     * 如果n为正数，则插入在从左往右第一个小于x的数之前
     * 如果n为负数，则插入在从左往右第一个大于x的数之前
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
