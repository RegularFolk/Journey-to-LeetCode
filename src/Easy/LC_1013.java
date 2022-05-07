package Easy;

public class LC_1013 {
    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10}));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        int leftCursor = -1;
        int rightCursor = -1;
        int leftSum = 0;
        int rightSum = 0;
        boolean zero = true;
        for (int i : arr) {
            sum += i;
            if (i != 0 && zero) {
                zero = false;
            }
        }
        if (zero) {
            return true;
        } else if (sum % 3 != 0) {
            return false;
        } else {
            sum = sum / 3;
        }
        do {
            leftCursor++;
            if (leftCursor == arr.length - 1) {
                return false;
            }
            leftSum += arr[leftCursor];
        } while (leftSum != sum);
        do {
            rightCursor++;
            if (rightCursor + leftCursor == arr.length - 1) {
                return false;
            }
            rightSum += arr[arr.length - rightCursor - 1];
        } while (rightSum != sum);
        return (leftCursor + rightCursor <= arr.length - 2) && (leftCursor != -1) && (rightCursor != -1);
    }
}
