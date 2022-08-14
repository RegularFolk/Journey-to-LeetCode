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

    private void quickSort(int[] numbs, int left, int right) { //������
        int temp;                                    //temp���ڽ���
        int leftCursor = left;
        int rightCursor = right;
        int pivot = numbs[(left + right) / 2];         //�ڱ�����Ϊ��ǰ�Ƚϵ�������м�ֵ
        while (leftCursor < rightCursor) {
            while (numbs[leftCursor] < pivot) {             //��ָ�벻�������ҵ�һ�������ڱ���ֵ
                leftCursor++;
            }
            while (numbs[rightCursor] > pivot) {             //��ָ�벻�������ҵ�һ��С���ڱ���ֵ
                rightCursor--;
            }
            if (leftCursor <= rightCursor) {
                //����Ⱥź���Ҫ��������ָ��ָ����ͬλ��ʱ��������ԭ�ؽ���һ�Σ�
                //Ȼ��˴˴���ÿ�ֱȽϵĽ�ֶ�����������ָ����ȣ�Ȼ�����ֵݹ��ǷǾ��Ȳ𿪵�
                temp = numbs[leftCursor];
                numbs[leftCursor] = numbs[rightCursor];
                numbs[rightCursor] = temp;
                leftCursor++;                  //������֮��Ҫ�ƶ�����ָ�룬��������ѭ���ķ���
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

    private void quickSort1(int[] numbs, int left, int right) {   //�ݹ��
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
