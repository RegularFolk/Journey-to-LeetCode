package CrackCodeInterview;

public class Interview_03_01 {
    private static class TripleInOne {
        int[] stack;
        int[][] prop = new int[3][2];
        int stackSize;

        public TripleInOne(int stackSize) {
            stack = new int[stackSize * 3];
            this.stackSize = stackSize;
            prop[0][0] = prop[0][1] = 0;
            prop[1][0] = prop[1][1] = stackSize;
            prop[2][0] = prop[2][1] = stackSize * 2;
        }

        public void push(int stackNum, int value) {
            if (prop[stackNum][1] < stackSize * (stackNum + 1)) {
                stack[prop[stackNum][1]++] = value;
            }
        }

        public int pop(int stackNum) {
            return isEmpty(stackNum) ? -1 : stack[--prop[stackNum][1]];
        }

        public int peek(int stackNum) {
            return isEmpty(stackNum) ? -1 : stack[prop[stackNum][1] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return prop[stackNum][1] == prop[stackNum][0];
        }
    }
}
