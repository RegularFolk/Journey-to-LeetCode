package NoteBook.SortingAlgorithm;

import java.util.Scanner;

public class BubbleSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbs = new int[n];
        for (int i = 0; i < n; i++) {
            numbs[i] = sc.nextInt();
        }
        bubbleSorting(numbs);
        for (int i = 0; i < n; i++) {
            System.out.println(numbs[i]);
        }
    }

    public static void bubbleSorting(int[] numbs) {
        int temp;
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = 0; j < numbs.length - i - 1; j++) {
                if (numbs[j] >= numbs[j + 1]) {
                    temp = numbs[j];
                    numbs[j] = numbs[j + 1];
                    numbs[j + 1] = temp;
                }
            }
        }
    }
}
