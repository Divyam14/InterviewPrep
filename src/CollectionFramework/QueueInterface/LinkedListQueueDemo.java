package CollectionFramework.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("A");
        queue.offer("B");
        queue.offer(null); // allowed in LinkedList

        System.out.println("Queue: " + queue);

        System.out.println("poll(): " + queue.poll());
        System.out.println("After poll: " + queue);
    }
}

