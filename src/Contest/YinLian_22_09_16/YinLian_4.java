package Contest.YinLian_22_09_16;

import org.junit.Test;

import java.util.*;

public class YinLian_4 {
    /*
     * 构造题
     * 利用散列表+优先队列
     * 35/72 AC失败
     * */
    static class VendingMachine {
        //<时间，数量>,优先队列为以时间排序的小根堆
        HashMap<String, PriorityQueue<SetOfItem>> map;
        HashMap<String, Double> discount;

        public VendingMachine() {
            map = new HashMap<>();
            discount = new HashMap<>();
        }

        public void addItem(int time, int number, String item, int price, int duration) {
            PriorityQueue<SetOfItem> queue = map.getOrDefault(item, null);
            SetOfItem setOfItem = new SetOfItem(number, time + duration, price);
            if (queue == null || queue.size() == 0) {
                PriorityQueue<SetOfItem> newQueue = new PriorityQueue<>((a, b) -> {
                    if (a.price != b.price) return a.price - b.price;
                    return a.time - b.time;
                });
                newQueue.add(setOfItem);
                map.put(item, newQueue);
            } else queue.add(setOfItem);
        }

        public long sell(int time, String customer, String item, int number) {
            PriorityQueue<SetOfItem> items = map.get(item);
            if (items == null || items.size() == 0) return -1;
            while (!items.isEmpty() && items.peek().time < time) {
                items.poll();
            }
            LinkedList<SetOfItem> list = new LinkedList<>();
            int sum = 0;
            while (!items.isEmpty() && sum < number) {
                SetOfItem poll = items.poll();
                sum += poll.number;
                list.addLast(poll);
            }
            if (sum < number) {
                items.addAll(list);
                return -1;
            }
            long cost = 0L;
            for (SetOfItem setOfItem : list) {
                long take = Math.min(setOfItem.number, number);
                number -= take;
                cost += take * setOfItem.price;
                setOfItem.number -= take;
                if (setOfItem.number > 0) items.add(setOfItem);
            }
            Double discountValue = discount.getOrDefault(customer, 1D);
            cost = (long) Math.ceil(discountValue * cost);
            discountValue = Math.max(0.7D, discountValue - 0.01);
            discount.put(customer, discountValue);
            return cost;
        }

        private static class SetOfItem {
            public int number, time, price;

            public SetOfItem(int number, int time, int price) {
                this.number = number;
                this.time = time;
                this.price = price;
            }
        }
    }

    @Test
    public void z() {
        VendingMachine machine = new VendingMachine();
        machine.addItem(0, 1, "Apple", 4, 3);
        machine.addItem(1, 3, "Apple", 4, 2);
        long sell = machine.sell(2, "Mary", "Apple", 2);
        System.out.println(sell);
    }
}
