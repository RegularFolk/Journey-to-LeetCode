package utils;

import java.util.List;

public class ArrayUtil {

    public static <T> void printDoubleList(List<List<T>> lists) {
        int count = 0;
        for (List<T> list : lists) {
            count += list.size();
            System.out.print("[");
            for (T t : list) {
                System.out.print(t + "\t");
            }
            System.out.println("]");
        }
        System.out.println("count = " + count);
        System.out.println("lists.size() = " + lists.size());
    }

    public static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t + "\t");
        }
        System.out.println("list.size() = " + list.size());
    }
}
