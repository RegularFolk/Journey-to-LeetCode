package Leet.Easy;

public class LC_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int add = empty / numExchange;
            ans += add;
            empty = empty % numExchange + add;
        }
        return ans;
    }
}
