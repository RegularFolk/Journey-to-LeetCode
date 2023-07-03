package JzOffer.JzOffer_II;

public class JzOfferII_072 {
    /*
     * ���ֲ�����ƽ����
     * �ҵ�ƽ����С�ڵ��ڸ����������ֵ
     * */
    public int mySqrt(int x) {
        int left = 1, right = x, ans = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;//����������λ���㣬��������ķ���
            if (((long) mid * mid) <= x) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}
