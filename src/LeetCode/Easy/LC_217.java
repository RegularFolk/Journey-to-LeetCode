package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class LC_217 {
    public static void main(String[] args) {
        //没什么意义
    }

    public static boolean containsDuplicate(int[] numbs) {
        Set<Integer> set = new HashSet<>();
        for (int i : numbs) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
