package CrackCodeInterview.XVI_Medium;


public class Interview_16_11 {
    /*
     * �����ͷ����仯�ݹ�
     * һ������£���̵ľ���ȫ��shorter���ڶ��̵��Ǹ�һ��Ϊlonger���Դ����������ȫ��longer
     * */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{longer * k};
        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ans[i] = shorter * (k - i) + longer * (i);
        }
        return ans;
    }

}
