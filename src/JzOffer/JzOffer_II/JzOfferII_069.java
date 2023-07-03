package JzOffer.JzOffer_II;

public class JzOfferII_069 {
    /*
     * 二分查找的应用
     * */
    public int peakIndexInMountainArray(int[] arr) {
        int ans = -1, left = 0, right = arr.length - 1;
        while (left <= right) {
            ans = (left + right) >> 1;
            if (ans > 0 && arr[ans - 1] < arr[ans] && arr[ans + 1] < arr[ans]) return ans;
            else if (arr[ans + 1] > arr[ans]) left = ans + 1;
            else right = ans - 1;
        }
        return ans;
    }
}
