package Leet.Hard;

public class LC_135_mark {
    /*
     * �ѵ�����̰�ĵ��Ƶ�������Ӿֲ������Ƴ�ȫ������
     * �ȴ������ұ�����ֻ�Ƚ��ұ��Ƿ����ߴ�
     * �ٴ������������ֻ�Ƚ�����Ƿ���ұߴ�
     * ������������˼·�����Ǵ�ȫ�ֳ��������������ѻ�
     * */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int ans = 0;
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        for (int i : candy) {
            ans += i;
        }
        return ans;
    }
}
