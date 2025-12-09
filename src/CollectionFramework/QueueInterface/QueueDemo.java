package CollectionFramework.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Insertion
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Queue: " + queue); // [10, 20, 30]

        // Peek (head element)
        System.out.println("peek(): " + queue.peek()); // 10

        // Removal (FIFO)
        System.out.println("poll(): " + queue.poll()); // 10
        System.out.println("After poll: " + queue);    // [20, 30]

        // Difference between remove() and poll()
        queue.clear();
        System.out.println("poll() on empty queue: " + queue.poll()); // null

        // Uncomment to see exception
        // queue.remove(); // NoSuchElementException
    }
}

