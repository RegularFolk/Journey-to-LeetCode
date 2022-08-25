package CrackCodeInterview.V_BitOperation;

public class Interview_05_02 {

    /*
     * num介于0-1之间，小数部分不断乘2,30次以内完全变为整数，否则返回error
     * */
    public String printBin(double num) {
        if (num == 0 || num == 1) {
            return String.valueOf(num);
        }
        double expend = num;
        int count = 0;
        while (count++ < 30) {
            expend *= 2;
            if (expend == Math.floor(expend)) {
                break;
            }
        }
        if (count == 31) {
            return "ERROR";
        }
        return "0." + form((int) expend, count);
    }

    private String form(int expend, int count) {
        StringBuilder builder = new StringBuilder();
        while (expend > 0) {
            builder.append(expend & 1);
            expend >>= 1;
            count--;
        }
        return builder.append("0".repeat(count)).reverse().toString();
    }
}
