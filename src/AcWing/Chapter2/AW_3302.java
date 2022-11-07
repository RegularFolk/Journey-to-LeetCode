package AcWing.Chapter2;

import AcWing.util.AWUtils;
import org.junit.Test;

import java.util.*;

/*
    ����һ�����ʽ����������������� +,-,*,/���� �� �� �����������ܰ������ţ�����������ʽ������ֵ��

    ע�⣺

    ���ݱ�֤�����ı��ʽ�Ϸ���
    ��Ŀ��֤���� - ֻ��Ϊ���ų��֣�������Ϊ���ų��֣����磬-1+2,(2+2)*(-(1+1)+2) ֮����ʽ��������֡�
    ��Ŀ��֤���ʽ���������־�Ϊ��������
    ��Ŀ��֤���ʽ���м��������Լ�����У��������� 231?1��
    ��Ŀ�е�������ָ�� 0 ȡ����Ҳ����˵���ڴ��� 0 �Ľ������ȡ�������� 5/3=1������С�� 0 �Ľ������ȡ�������� 5/(1?4)=?1��
    C++��Java�е�����Ĭ��������ȡ����Python�е�����//Ĭ������ȡ�������Python��eval()�����е�����Ҳ������ȡ�����ڱ����в���ֱ��ʹ�á�
    �����ʽ
    ��һ�У�Ϊ�������ʽ��

    �����ʽ
    ��һ�У�Ϊ���ʽ�Ľ����

    ���ݷ�Χ
    ���ʽ�ĳ��Ȳ����� 105��

    ����������
    (2+2)*(1+1)
    ���������
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
    * ��׺���ʽ�ļ���ͺ�׺��ȣ�Ҫ����һ���洢��������ջ
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
            } else if (isNum(curChar)) {//ȡ����������
                int val = 0;
                for (int j = i; j < chars.length && isNum(chars[j]); j++, i = j) {
                    val = val * 10 + chars[j] - '0';
                }
                i--;
                nums.push(val);
            } else { //������
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
