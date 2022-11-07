package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class LC_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] students = new int[n1];
        int[] sandwiches = new int[n1];
        for (int i = 0; i < n1; i++) {
            students[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            sandwiches[i] = sc.nextInt();
        }
        System.out.println(countStudents(students, sandwiches));
        System.out.println(countStudents2(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {//使用ArrayList会牺牲效率
        int count = 0;
        ArrayList<Boolean> student = new ArrayList<>();
        ArrayList<Boolean> sand = new ArrayList<>();
        for (int i : students) {
            if (i == 1) {
                student.add(true);
            } else {
                student.add(false);
            }
        }
        for (int i : sandwiches) {
            if (i == 1) {
                sand.add(true);
            } else {
                sand.add(false);
            }
        }
        while (count < student.size() && !sand.isEmpty()) {
            if (student.get(0) == sand.get(0)) {
                student.remove(0);
                sand.remove(0);
                count = 0;
            } else {
                student.add(student.get(0));
                student.remove(0);
                count++;
            }
        }
        return sand.size();
    }

    public static int countStudents2(int[] students, int[] sandwiches) {
        int count1 = 0;
        int count2;
        for (int i : students) {
            if (i == 1) {
                count1++;
            }
        }
        count2 = students.length - count1;
        for (int i : sandwiches) {
            if (i == 1 && count1 > 0) {
                count1--;
            } else if (i == 0 && count2 > 0) {
                count2--;
            } else if (count1 <= 0 || count2 <= 0) {
                break;
            }
        }
        return Math.max(count1, count2);
    }
}
