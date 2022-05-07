package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
模拟
哈希
*/

public class LC_1 {
    public static void main(String[] args) {
        int target;
        int n;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10000];
        int[] ans = new int[2];
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        target = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(ans[0] + " , " + ans[1]);
    }

    public static int[] twoSum(int[] numbs, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbs.length);
        for (int i = 0; i < numbs.length; i++) {
            if (!map.containsKey(target - numbs[i])) {
                map.put(numbs[i], i);
            } else {
                return new int[]{i, map.get(target - numbs[i])};
            }
        }
        return null;
    }
}
