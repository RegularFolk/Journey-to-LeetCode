package Easy;

public class LC_860 {
    /*
     * ̰��
     * �Ӵ��ŵĿ�ʼ��
     * */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 10) {
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            } else five++;
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }
}
