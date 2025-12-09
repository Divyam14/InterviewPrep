package CollectionFramework.QueueInterface;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        // Producer
        Runnable producer = () -> {
            try {
                queue.put(1);
                System.out.println("Produced 1");
                queue.put(2);
                System.out.println("Produced 2");
                queue.put(3); // will BLOCK until space available
                System.out.println("Produced 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Consumer
        Runnable consumer = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(1000);
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(1000);
                System.out.println("Consumed: " + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

