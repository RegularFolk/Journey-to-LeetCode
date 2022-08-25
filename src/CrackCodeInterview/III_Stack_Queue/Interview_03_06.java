package CrackCodeInterview.III_Stack_Queue;

import java.util.LinkedList;

public class Interview_03_06 {
    private static class AnimalShelf {
        LinkedList<Integer> dog;
        LinkedList<Integer> dogAge;
        LinkedList<Integer> cat;
        LinkedList<Integer> catAge;
        int age;

        public AnimalShelf() {
            dog = new LinkedList<>();
            dogAge = new LinkedList<>();
            cat = new LinkedList<>();
            catAge = new LinkedList<>();
            age = 0;
        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                cat.add(animal[0]);
                catAge.add(age++);
            } else {
                dog.add(animal[0]);
                dogAge.add(age++);
            }
        }

        public int[] dequeueAny() {
            if (cat.size() == 0 && dog.size() == 0) {
                return new int[]{-1, -1};
            } else if (cat.size() == 0) {
                dogAge.removeFirst();
                return new int[]{dog.removeFirst(), 1};
            } else if (dog.size() == 0) {
                catAge.removeFirst();
                return new int[]{cat.removeFirst(), 0};
            }
            if (dogAge.getFirst() < catAge.getFirst()) {
                dogAge.removeFirst();
                return new int[]{dog.removeFirst(), 1};
            } else {
                catAge.removeFirst();
                return new int[]{cat.removeFirst(), 0};
            }
        }

        public int[] dequeueDog() {
            if (dogAge.size() > 0) {
                dogAge.removeFirst();
                return new int[]{dog.removeFirst(), 1};
            } else {
                return new int[]{-1, -1};
            }
        }

        public int[] dequeueCat() {
            if (catAge.size() > 0) {
                catAge.removeFirst();
                return new int[]{cat.removeFirst(), 0};
            } else {
                return new int[]{-1, -1};
            }
        }
    }
}
