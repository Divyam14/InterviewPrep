package CollectionFramework.MapInterface;

import java.util.*;
import java.util.concurrent.*;


/*
“ConcurrentHashMap is a thread-safe Map implementation that allows
concurrent read and write operations without locking the entire map.
It uses fine-grained bucket-level locking and CAS operations.
Its iterators are weakly consistent, meaning they do not throw ConcurrentModificationException
 and may reflect some, but not necessarily all, concurrent updates.”

 “ConcurrentHashMap guarantees data consistency even under concurrent modifications.”
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        Runnable writer = () -> {
            for (int i = 0; i < 5; i++) {
                map.put("K" + i, i);
            }
        };

        Runnable reader = () -> {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(Thread.currentThread().getName() + " -> " + entry);
            }
        };

        Thread t1 = new Thread(writer, "Writer");
        Thread t2 = new Thread(reader, "Reader-1");
        Thread t3 = new Thread(reader, "Reader-2");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Map: " + map);
    }
}

