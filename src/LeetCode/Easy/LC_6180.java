package LeetCode.Easy;

public class LC_6180 {
    public int smallestEvenMultiple(int n) {
        return (n & 1) == 1 ? n * 2 : n;
    }
}
