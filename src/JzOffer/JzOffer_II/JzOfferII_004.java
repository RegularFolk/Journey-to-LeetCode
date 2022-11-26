package JzOffer.JzOffer_II;

public class JzOfferII_004 {
    /*
     * λ��ͳ��
     *   ��¼������ֵ��ÿһλ�������˶��ٴ�1���ٶ�ÿһλ����mod 3�����µ���ɱ���ֻ����һ�ε���
     * һ�����ƿ��Խ�����������ͬ����
     * */
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        int ans = 0;
        for (int num : nums) {
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] += num & 1;
                num >>= 1;
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            ans += ((cnt[i] % 3) & 1) << i;
        }
        return ans;
    }
}
