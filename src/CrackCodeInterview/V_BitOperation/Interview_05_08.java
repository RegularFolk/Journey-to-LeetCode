package CrackCodeInterview.V_BitOperation;

public class Interview_05_08 {
    /*
    * 看不懂题
    * */
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];
        int oneRow = w / 32;
        int head = oneRow * y + x1 / 32;
        int tail = oneRow * y + x2 / 32;
        for (int i = head; i <= tail; i++) {
            res[i] = -1;
        }
        res[head] = res[head] >>> (x1 % 32);
        res[tail] = res[tail] & (Integer.MIN_VALUE >> (x2 % 32));
        return res;
    }
}
