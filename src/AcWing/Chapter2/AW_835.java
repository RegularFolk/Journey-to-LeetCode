package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.ArrayList;

/*
    维护一个字符串集合，支持两种操作：

    I x 向集合中插入一个字符串 x；
    Q x 询问一个字符串在集合中出现了多少次。
    共有 N 个操作，输入的字符串总长度不超过 105，字符串仅包含小写英文字母。

    输入格式
    第一行包含整数 N，表示操作数。

    接下来 N 行，每行包含一个操作指令，指令为 I x 或 Q x 中的一种。

    输出格式
    对于每个询问指令 Q x，都要输出一个整数作为结果，表示 x 在集合中出现的次数。

    每个结果占一行。

    数据范围
    1≤N≤2*104
    输入样例：
    5
    I abc
    Q abc
    Q ab
    I ab
    Q ab
    输出样例：
    1
    0
    1
* */
public class AW_835 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        String[] s = AWUtils.stringArrayInput(n);
        ArrayList<Integer> ans = tire(s);
        AWUtils.printListByLine(ans);
    }

    private static ArrayList<Integer> tire(String[] s) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (String s1 : s) {
            if (s1.startsWith("Q")) {
                ans.add(query(s1.substring(2).toCharArray()));
            } else {
                insert(s1.substring(2).toCharArray());
            }
        }
        return ans;
    }

    private static int idx = 0;  //idx是去掉复用节点一共插入了几个
    private static final int n = 100010;  //n表示输入的所有字符串总长度
    private static final int[][] son = new int[n][26];//用二维数组模拟树形结构。注意这个树的结构很特殊，树与树之间不是对齐的
    private static final int[] cnt = new int[n];

    private static Integer query(char[] string) {
        int last = 0;  //不断记录查询过程中路径末尾的节点
        for (char c : string) {
            int index = c - 'a';
            if (son[last][index] == 0) return 0;//查找过程中断了，说明不存在
            last = son[last][index];
        }
        return cnt[last];
    }

    private static void insert(char[] string) {
        int last = 0;
        for (char c : string) {
            int index = c - 'a';
            if (son[last][index] == 0) son[last][index] = ++idx;//如果为0说明是一个新的分支，不为0说明原先已经有了，可以在其基础上延伸
            last = son[last][index];
        }
        cnt[last]++;
    }
}
