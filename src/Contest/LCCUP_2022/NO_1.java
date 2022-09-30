package Contest.LCCUP_2022;

public class NO_1 {
    /*
     * �ȶ�����ͳ�ƣ��ٶ�ͳ�ƺ���з���
     * 1:���� 0:ƽ�� -1:�½�
     * */
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int[] recA = new int[temperatureA.length - 1], recB = new int[temperatureB.length - 1];
        for (int i = 0; i < recA.length; i++) {
            recA[i] = Integer.compare(temperatureA[i + 1], temperatureA[i]);
            recB[i] = Integer.compare(temperatureB[i + 1], temperatureB[i]);
        }
        int ans = 0, cur = 0;
        for (int i = 0; i < recA.length; i++) {
            if ((recA[i] == 0 && recB[i] == 0) || (recA[i] * recB[i] > 0)) cur++;
            else cur = 0;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
