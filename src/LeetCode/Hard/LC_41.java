package LeetCode.Hard;

public class LC_41 {

    /*
    * ԭ�ع�ϣ
    * */
    public static int firstMissingPositive(int[] numbs) {
        for (int i = 0; i < numbs.length; i++) {
            while (numbs[i] >= 1 && numbs[i] <= numbs.length && numbs[numbs[i] - 1] != numbs[i]) {
                int temp = numbs[numbs[i] - 1];  //ע�⽻��˳��
                numbs[numbs[i] - 1] = numbs[i];
                numbs[i] = temp;
            }
        }
        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] != i + 1) {
                return i + 1;
            }
        }
        return numbs.length + 1;
    }
}
