package JzOffer;

import java.util.Stack;

public class JzOffer_09 {

    Stack<Integer> store, temp;

    public JzOffer_09() {
        store = new Stack<>();
        temp = new Stack<>();
    }

    //进行一定的优化，连续的add和delete不需要来回倒腾

    public void appendTail(int value) {
        if (temp.size() != 0) {
            while (temp.size() > 0) {
                store.push(temp.pop());
            }
        }
        store.push(value);
    }

    public int deleteHead() {
        if (temp.size() != 0) {
            return temp.pop();
        } else if (store.size() == 0) {
            return -1;
        } else {
            while (store.size() > 1) {
                temp.push(store.pop());
            }
            return store.pop();
        }
    }
}
