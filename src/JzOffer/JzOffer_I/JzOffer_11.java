package JzOffer.JzOffer_I;

public class JzOffer_11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int lc = 0, rc = numbers.length - 1, mid = lc;
        while (numbers[lc] >= numbers[rc]) {
            if (rc - lc == 1) {
                mid = rc;
                break;
            }
            mid = (lc + rc) / 2;
            if (numbers[lc] == numbers[mid] && numbers[rc] == numbers[mid]) {
                return minInOrder(numbers, lc, rc);//如果左右中间三个指针指向的值相等，就在这个范围内进行顺序查询
            }
            if (numbers[mid] >= numbers[lc]) {
                lc = mid;
            } else if (numbers[mid] <= numbers[rc]) {
                rc = mid;
            }
        }
        return numbers[mid];
    }

    private int minInOrder(int[] numbers, int lc, int rc) {
        int ans = numbers[lc];
        while (++lc <= rc) {
            ans = Math.min(numbers[lc], ans);
        }
        return ans;
    }
}
