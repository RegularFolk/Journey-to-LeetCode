package JzOffer.JzOffer_II;

public class JzOfferII_006 {
    /*
     * 双指针 真模板题
     * */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l, r};
            else if (sum < target) l++;
            else r--;
        }
        throw new RuntimeException();
    }
}
