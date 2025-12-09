package CollectionFramework.QueueInterface;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueComparatorDemo {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max-heap

        pq.offer(10);
        pq.offer(40);
        pq.offer(20);

        System.out.println("Max PriorityQueue: " + pq);

        System.out.println("poll(): " + pq.poll()); // 40
        System.out.println("poll(): " + pq.poll()); // 20
    }
}
