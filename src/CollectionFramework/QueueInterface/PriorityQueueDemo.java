package CollectionFramework.QueueInterface;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        pq.offer(5);

        System.out.println("PriorityQueue (internal order): " + pq);

        // Removal happens based on priority (min element)
        System.out.println("poll(): " + pq.poll()); // 5
        System.out.println("poll(): " + pq.poll()); // 10

        System.out.println("After polling: " + pq);

        // ❌ null not allowed
        // pq.offer(null); // NullPointerException
    }
}

