package JzOffer.JzOffer_I;

import java.util.LinkedList;

public class JzOffer_59_2 {

    private static class MaxQueue { //维护一个单调队列和普通队列
        LinkedList<Integer> mono; //存储下标
        int[] queue;
        int left, right; //queue中有效数据的范围

        public MaxQueue() {
            mono = new LinkedList<>();
            queue = new int[15000];
            left = 0;    //准备pop的值
            right = 0;   //下一个add的位置
        }

        public int max_value() {
            return mono.size() == 0 ? -1 : queue[mono.getFirst()];
        }

        public void push_back(int value) {
            queue[right++] = value;
            while (mono.size() > 0 && queue[mono.getLast()] <= value) {
                mono.removeLast();
            }
            mono.add(right - 1);
        }

        public int pop_front() {
            if (left == right) {
                return -1;
            }
            left++;
            if (mono.getFirst() == left - 1) {
                mono.removeFirst();
            }
            return queue[left - 1];
        }
    }
}
