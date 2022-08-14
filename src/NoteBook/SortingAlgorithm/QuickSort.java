package NoteBook.SortingAlgorithm;

import org.junit.Test;

import java.util.Scanner;

public class QuickSort {

    @Test
    public void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbs = new int[n];
        for (int i = 0; i < n; i++) {
            numbs[i] = sc.nextInt();
        }
        quickSort(numbs, 0, numbs.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(numbs[i]);
        }
    }

    private void quickSort(int[] numbs, int left, int right) { //迭代版
        int temp;                                    //temp用于交换
        int leftCursor = left;
        int rightCursor = right;
        int pivot = numbs[(left + right) / 2];         //哨兵设置为当前比较的数组的中间值
        while (leftCursor < rightCursor) {
            while (numbs[leftCursor] < pivot) {             //左指针不断右移找到一个大于哨兵的值
                leftCursor++;
            }
            while (numbs[rightCursor] > pivot) {             //右指针不断左移找到一个小于哨兵的值
                rightCursor--;
            }
            if (leftCursor <= rightCursor) {
                //这个等号很重要，当左右指针指向相同位置时，让他们原地交换一次，
                //然后彼此错开，每轮比较的结局都是左右两个指针相等，然后下轮递归是非均匀拆开的
                temp = numbs[leftCursor];
                numbs[leftCursor] = numbs[rightCursor];
                numbs[rightCursor] = temp;
                leftCursor++;                  //交换了之后要移动两个指针，否则有死循环的风险
                rightCursor--;
            }
        }
        if (rightCursor > left) {
            quickSort(numbs, left, rightCursor);
        }
        if (leftCursor < right) {
            quickSort(numbs, leftCursor, right);
        }
    }

    private void quickSort1(int[] numbs, int left, int right) {   //递归版
        if (left > right) {
            int index = partition(numbs, left, right);
            if (index > left) {
                quickSort1(numbs, left, index - 1);
            }
            if (index < right) {
                quickSort1(numbs, index + 1, right);
            }
        }
    }

    private int partition(int[] numbs, int left, int right) {
        int pivot = (left + right) >> 1;
        swap(numbs, pivot, right);
        while (pivot < right) {
            if (numbs[pivot] < numbs[right]) {
                if (left != pivot) {
                    swap(numbs, pivot, left);
                }
                left++;
            }
            pivot++;
        }
        swap(numbs, left, right);
        return left;
    }

    private void swap(int[] numbs, int a, int b) {
        int temp = numbs[a];
        numbs[a] = numbs[b];
        numbs[b] = temp;
    }
}
