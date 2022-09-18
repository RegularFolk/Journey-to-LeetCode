package Easy;

public class LC_1608 {
    /*
     * 统计每个数字出现的次数再进行分析
     * */
    public int specialArray(int[] nums) {
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (nums.length - sum == i) return i;
            sum += count[i];
        }
        return -1;
    }
}
