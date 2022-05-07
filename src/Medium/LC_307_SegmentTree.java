package Medium;

import java.util.*;

//树状数组、线段树    知识盲区
public class LC_307_SegmentTree {
    static class NumArray {
        int[] arr;  //线段树数组，下标从一开始
        int n;  //数据个数

        public NumArray(int[] numbs) {
            n = numbs.length;
            arr = new int[n * 2];
            buildTree(numbs);
        }

        private void buildTree(int[] numbs) {  //自下向上构建线段树
            for (int i = n, j = 0; i < 2 * n; i++, j++) {
                arr[i] = numbs[j];      //数组后一半存的是初始数据
            }
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i * 2] + arr[i * 2 + 1];
            }//数组前一半是各种区间内的和
        }

        public void update(int index, int val) {
            index += n;//index往后移动n格刚好是这个原始数据在数组中的位置
            arr[index] = val; //更新这个位置的值
            //开始往上重构线段树
            while (index > 0) {
                int left = index;
                int right = index;
                if (index % 2 == 0) {  //如果index是偶数，说明当前是一个左儿子
                    right = index + 1;
                } else {        //如果index是奇数，说明当前是一个右儿子
                    left = index - 1;
                }
                arr[index / 2] = arr[left] + arr[right];
                index /= 2;
            }
        }

        public int sumRange(int left, int right) {
            //自下往上累加起来所有范围内的值
            left += n;  //让left和right指向原始数据所在的数组位置
            right += n;
            int ans = 0;
            while (left <= right) {
                if (left % 2 == 1) {
                    //如果左区间是左节点，即偶数，无需求和，直接往上找即可
                    //如果左区间是右节点，即奇数，则加上这个节点，然后往右找(变成偶数),相当于换了一个老爸
                    ans += arr[left];
                    left++;
                }
                if (right % 2 == 0) {
                    //右区间同左区间
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
