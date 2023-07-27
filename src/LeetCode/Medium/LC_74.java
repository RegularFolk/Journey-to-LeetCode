package LeetCode.Medium;

public class LC_74 {
    /*
     * ��λ��������
     * ��ˮƽ������Ȼ��ֱ������������Ҳ���ԣ�
     * �����ѣ��ҵ���һ��С��tar�ģ��������ѣ��ҵ���һ������tar��
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            while (col >= 0 && matrix[row][col] >= target) {
                if (matrix[row][col] == target) return true;
                col--;
            }
            if (col >= 0) {
                while (row < matrix.length && matrix[row][col] <= target) {
                    if (matrix[row][col] == target) return true;
                    row++;
                }
            }
        }
        return false;
    }
}
