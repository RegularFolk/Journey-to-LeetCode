package AcWing.Chapter1;

/*
    给定一个长度为 n 的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。

    输入格式
    第一行包含整数 n。

    第二行包含 n 个整数（均在 0?105 范围内），表示整数序列。

    输出格式
    共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。

    数据范围
    1≤n≤105
    输入样例：
    5
    1 2 2 3 5
    输出样例：
    3
* */
import AcWing.util.AWUtils;

public class AW_799 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        int[] arr = AWUtils.intArrayInput(n);
        int ans = longestUniqueNum(arr);
        System.out.println(ans);
    }

    private static int longestUniqueNum(int[] arr) {
        boolean[] map = new boolean[100001];
        int ans = 0, l = 0, r = 0;
        while (r < arr.length) {
            while (r < arr.length && !map[arr[r]]) map[arr[r++]] = true;//移动右指针
            ans = Math.max(r - l, ans);
            while (r < arr.length && map[arr[r]]) map[arr[l++]] = false;//移动左指针
        }
        return ans;
    }
}
