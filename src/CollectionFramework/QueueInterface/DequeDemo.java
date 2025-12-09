package CollectionFramework.QueueInterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // As Queue (FIFO)
        deque.offerLast(10);
        deque.offerLast(20);
        deque.offerLast(30);
        System.out.println("Deque as Queue: " + deque);

        System.out.println("pollFirst(): " + deque.pollFirst()); // 10
        System.out.println("After pollFirst: " + deque);

        // As Stack (LIFO)
        deque.push(100);
        deque.push(200);
        System.out.println("Deque as Stack: " + deque);

        System.out.println("pop(): " + deque.pop()); // 200
        System.out.println("After pop: " + deque);

        // ❌ null not allowed
        // deque.add(null); // NullPointerException
    }
}

