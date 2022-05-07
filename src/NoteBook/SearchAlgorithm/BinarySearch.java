package NoteBook.SearchAlgorithm;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数据个数：");
        int n = sc.nextInt();
        System.out.println("请有序输入数据：");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("输入查找数据：");
        int target = sc.nextInt();
        if (myBinarySearch(arr, target) == -1) {
            System.out.println("查找数据不在数组中！");
        } else {
            System.out.println("查找数据索引值为： " + myBinarySearch(arr, target));
        }
    }

    public static int myBinarySearch(int[] arr, int target) {//正序数组
        int mid = 0;
        for (int low = 0, high = arr.length - 1; low <= high; ) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                break;
            } else if (low == high) {
                mid = -1;
                break;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return mid;
    }
}
