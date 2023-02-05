package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JzOfferII_037 {
    /*
    * 类似单调栈的应用
    * */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> left = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) left.push(asteroid);
            else {
                while (!left.isEmpty() && left.peek() < -1 * asteroid) left.pop();
                if (left.isEmpty()) ans.add(asteroid);
                else if (left.peek() == -1 * asteroid) left.pop();
            }
        }
        ans.addAll(left);
        int[] output = new int[ans.size()];
        int count = 0;
        for (Integer integer : ans) output[count++] = integer;
        return output;
    }
}
