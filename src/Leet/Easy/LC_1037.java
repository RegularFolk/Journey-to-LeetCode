package Leet.Easy;

public class LC_1037 {
    public boolean isBoomerang(int[][] points) {
        double dx1 = points[0][0] - points[1][0],
                dx2 = points[0][0] - points[2][0],
                dy1 = points[0][1] - points[1][1],
                dy2 = points[0][1] - points[2][1];
        //return ((dy1 == 0 ^ dy2 == 0) || (dx1 / dy1 != dx2 / dy2)) && !((dx1 == 0 ^ dy1 == 0) && (dx2 == 0 ^ dy2 == 0));
        /*if ((dx1 == 0 && dy1 == 0) || (dx2 == 0 && dy2 == 0)) {//有重复点
            return false;
        } else if (dy1 == 0 ^ dy2 == 0) { //两者之一在一条水平线
            return true;
        } else if (dy1 == 0 && dy2 == 0) {
            return false;
        } else {
            return dx1 / dy1 != dx2 / dy2;
        }*/
        //用三目运算符化成一行，自己也看不懂了 O(∩_∩)O~
        //return (dx1 != 0 || dy1 != 0) && (dx2 != 0 || dy2 != 0) && (dy1 == 0 ^ dy2 == 0 || ((dy1 != 0 || dy2 != 0) && dx1 / dy1 != dx2 / dy2));
        //避免零的情况，使用十字相除即可
        return dx1 * dy2 != dx2 * dy1;
    }
}
