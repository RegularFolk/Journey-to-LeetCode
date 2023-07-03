package JzOffer.JzOffer_II;

public class JzOfferII_072 {
    /*
     * 二分查找找平方根
     * 找到平方后小于等于给定数的最大值
     * */
    public int mySqrt(int x) {
        int left = 1, right = x, ans = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;//相比于相加再位运算，消除溢出的风险
            if (((long) mid * mid) <= x) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}
