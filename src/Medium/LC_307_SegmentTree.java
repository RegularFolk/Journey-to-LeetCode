package Medium;

import java.util.*;

//��״���顢�߶���    ֪ʶä��
public class LC_307_SegmentTree {
    static class NumArray {
        int[] arr;  //�߶������飬�±��һ��ʼ
        int n;  //���ݸ���

        public NumArray(int[] numbs) {
            n = numbs.length;
            arr = new int[n * 2];
            buildTree(numbs);
        }

        private void buildTree(int[] numbs) {  //�������Ϲ����߶���
            for (int i = n, j = 0; i < 2 * n; i++, j++) {
                arr[i] = numbs[j];      //�����һ�����ǳ�ʼ����
            }
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i * 2] + arr[i * 2 + 1];
            }//����ǰһ���Ǹ��������ڵĺ�
        }

        public void update(int index, int val) {
            index += n;//index�����ƶ�n��պ������ԭʼ�����������е�λ��
            arr[index] = val; //�������λ�õ�ֵ
            //��ʼ�����ع��߶���
            while (index > 0) {
                int left = index;
                int right = index;
                if (index % 2 == 0) {  //���index��ż����˵����ǰ��һ�������
                    right = index + 1;
                } else {        //���index��������˵����ǰ��һ���Ҷ���
                    left = index - 1;
                }
                arr[index / 2] = arr[left] + arr[right];
                index /= 2;
            }
        }

        public int sumRange(int left, int right) {
            //���������ۼ��������з�Χ�ڵ�ֵ
            left += n;  //��left��rightָ��ԭʼ�������ڵ�����λ��
            right += n;
            int ans = 0;
            while (left <= right) {
                if (left % 2 == 1) {
                    //�������������ڵ㣬��ż����������ͣ�ֱ�������Ҽ���
                    //������������ҽڵ㣬�����������������ڵ㣬Ȼ��������(���ż��),�൱�ڻ���һ���ϰ�
                    ans += arr[left];
                    left++;
                }
                if (right % 2 == 0) {
                    //������ͬ������
                    ans += arr[right];
                    right--;
                }
                left /= 2;
                right /= 2;
            }
            return ans;
        }
    }
}
