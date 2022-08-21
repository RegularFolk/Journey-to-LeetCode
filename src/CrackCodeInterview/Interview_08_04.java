package CrackCodeInterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Interview_08_04 {
    /*
     * 动态规划
     *
     * 对于集合{a1,a2,a3,...,an},
     *  当n==1时 子集为{∅},{a1}
     *  当n==2时 子集为{∅},{a1},{a2},{a1,a2}
     *  当n==3时 子集为{∅},{a1},{a2},{a1,a2},{a3},{a1,a3},{a2,a3},{a1,a2,a3}
     *      ........
     *  规律:f(n)=f(n-1)+[把an置入f(n-1)的每个集合中]
     * */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> last = new ArrayList<>();
        last.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> lastList : last) {
                ArrayList<Integer> addList = new ArrayList<>(lastList);
                addList.add(num);
                current.add(addList);
            }
            current.addAll(last);
            last = current;
        }
        return last;
    }

    @Test
    public void t() {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print("integer = " + integer + '/');
            }
            System.out.println("==");
        }
    }
}
