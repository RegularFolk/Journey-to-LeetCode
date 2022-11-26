package LeetCode.Medium;

public class LC_799 {
    /*
    * 动态规划
    * */
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[query_row + 1][query_row + 1];
        tower[0][0] = poured;
        boolean flag = true;
        for (int row = 1; row < tower.length && flag; row++) {
            flag = false;//一层中必须至少有一个杯子溢出才有必要进入下一层
            for (int col = 0; col <= row; col++) {
                double left = Math.max(0, (col > 0 ? tower[row - 1][col - 1] - 1 : 0) / 2);
                double right = Math.max(0, (tower[row - 1][col] - 1) / 2);
                if (left + right > 1) flag = true;
                tower[row][col] = left + right;
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}
