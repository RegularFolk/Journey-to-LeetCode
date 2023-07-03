package JzOffer.JzOffer_II;

public class JzOfferII_073 {
    /*
     * 二分法猜答案
     * */
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(piles, mid, h)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    private boolean check(int[] piles, int mid, int h) {
        int ans = 0;
        for (int pile : piles) ans += Math.ceil(pile * 1.0 / mid);
        return ans <= h;
    }
}
