package Leet.Hard;

public class LC_135_mark {
    /*
     * 难点在于贪心的推导，本题从局部最优推出全局最优
     * 先从左往右遍历，只比较右边是否比左边大
     * 再从右往左遍历，只比较左边是否比右边大
     * 若是以找落差的思路，则是从全局出发，让问题困难化
     * */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int ans = 0;
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        for (int i : candy) {
            ans += i;
        }
        return ans;
    }
}
