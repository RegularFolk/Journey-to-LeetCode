package LeetCode.Easy;

public class LC_1845 {
    public int maximumPopulation(int[][] logs) {//利用差分数组，维护每一年的人口变化量
        int base = 1950, ans = 0, max = 0, count = 0;
        int[] years = new int[101];
        for (int[] log : logs) {
            years[log[0] - base]++;
            years[log[1] - base]--;
        }
        for (int i = 0; i < 101; i++) {
            count += years[i];
            if (count > max) {
                max = count;
                ans = i;
            }
        }
        return ans + base;
    }
}
