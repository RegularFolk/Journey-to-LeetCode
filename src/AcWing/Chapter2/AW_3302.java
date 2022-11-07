package AcWing.Chapter2;

import AcWing.util.AWUtils;
import org.junit.Test;

import java.util.*;

/*
    给定一个表达式，其中运算符仅包含 +,-,*,/（加 减 乘 整除），可能包含括号，请你求出表达式的最终值。

    注意：

    数据保证给定的表达式合法。
    题目保证符号 - 只作为减号出现，不会作为负号出现，例如，-1+2,(2+2)*(-(1+1)+2) 之类表达式均不会出现。
    题目保证表达式中所有数字均为正整数。
    题目保证表达式在中间计算过程以及结果中，均不超过 231?1。
    题目中的整除是指向 0 取整，也就是说对于大于 0 的结果向下取整，例如 5/3=1，对于小于 0 的结果向上取整，例如 5/(1?4)=?1。
    C++和Java中的整除默认是向零取整；Python中的整除//默认向下取整，因此Python的eval()函数中的整除也是向下取整，在本题中不能直接使用。
    输入格式
    共一行，为给定表达式。

    输出格式
    共一行，为表达式的结果。

    数据范围
    表达式的长度不超过 105。

    输入样例：
    (2+2)*(1+1)
    输出样例：
    8
* */
public class AW_3302 {
//    public static void main(String[] args) {
//        String s = AWUtils.stringInput();
//        int ans = calc(s.toCharArray());
//        System.out.println(ans);
//    }

    @Test
    public void x(){
        System.out.println("calc(\"1+612+2+3+6\".toCharArray()) = " + calc("1+612+2+3+6".toCharArray()));
    }

    private static final Stack<Integer> nums = new Stack<>();
    private static final Stack<Character> ops = new Stack<>();

    private static final Map<Character, Integer> rank = new HashMap<>();

    /*
    * 中缀表达式的计算和后缀相比，要多用一个存储操作符的栈
    * */
    private static int calc(char[] chars) {
        rank.put('+', 1);
        rank.put('-', 1);
        rank.put('*', 2);
        rank.put('/', 2);
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if (curChar == '(') ops.push('(');
            else if (curChar == ')') {
                while (ops.peek() != '(' && nums.size() > 1) {
                    doOp();
                }
                ops.pop();
            } else if (isNum(curChar)) {//取出完整的数
                int val = 0;
                for (int j = i; j < chars.length && isNum(chars[j]); j++, i = j) {
                    val = val * 10 + chars[j] - '0';
                }
                i--;
                nums.push(val);
            } else { //操作符
                Integer curRank = rank.get(curChar);
                while (!ops.isEmpty() && ops.peek() != '(' && curRank <= rank.get(ops.peek())) {
                    doOp();
                }
                ops.push(curChar);
            }
        }
        while (!ops.isEmpty()) doOp();
        return nums.peek();
    }

    private static void doOp() {
        Character c = ops.pop();
        Integer b = nums.pop();
        Integer a = nums.pop();
        nums.push(calc(a, b, c));
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static int calc(Integer a, Integer b, char c) {
        if ('+' == c) return a + b;
        else if ('-' == c) return a - b;
        else if ('*' == c) return a * b;
        else return a / b;
    }
}
