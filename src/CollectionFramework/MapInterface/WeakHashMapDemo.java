package CollectionFramework.MapInterface;

import java.util.*;

public class WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<Object, String> map = new WeakHashMap<>();

        Object key1 = new Object();
        Object key2 = new Object();

        map.put(key1, "value1");
        map.put(key2, "value2");

        System.out.println("Before nulling keys: " + map);

        // Remove strong reference to key1
        key1 = null;

        // Suggest GC
        System.gc();
        Thread.sleep(100); // just to give GC a chance

        System.out.println("After GC hint: " + map);
        System.out.println("Note: entry with collected key MAY disappear.");
    }
}

