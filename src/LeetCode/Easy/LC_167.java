package LeetCode.Easy;

public class LC_167 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (binarySearch(numbers, ans, target - numbers[i], i + 1)) {
                ans[0] = i + 1;
                return ans;
            }
        }
        return ans;
    }

    public static boolean binarySearch(int[] numbers, int[] ans, int i, int left) {
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == i) {
                ans[1] = mid + 1;
                return true;
            } else if (numbers[mid] < i) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static int[] twoSum1(int[] numbers, int target) {    //利用前后双指针
        int leftCursor = 0;
        int rightCursor = numbers.length - 1;
        int[] ans = new int[2];
        while (leftCursor < rightCursor) {
            int sum = numbers[leftCursor] + numbers[rightCursor];
            if (sum == target) {
                ans[0] = leftCursor + 1;
                ans[1] = rightCursor + 1;
                return ans;
            } else if (sum > target) {
                rightCursor--;
            } else {
                leftCursor++;
            }
        }
        return ans;
    }
}
