package CollectionFramework.MapInterface;

import java.util.*;

public class MapBasicDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        // put / overwrite
        map.put(101, "A");
        map.put(102, "B");
        map.put(103, "C");
        map.put(101, "UPDATED"); // same key → value overwritten

        System.out.println("Map: " + map);

        // get / contains
        System.out.println("get(102): " + map.get(102));          // B
        System.out.println("containsKey(103): " + map.containsKey(103));
        System.out.println("containsValue(\"C\"): " + map.containsValue("C"));

        // size / isEmpty
        System.out.println("size: " + map.size());
        System.out.println("isEmpty: " + map.isEmpty());

        // keySet view
        System.out.println("\nIterating over keys:");
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        // values view
        System.out.println("\nIterating over values:");
        for (String value : map.values()) {
            System.out.println(value);
        }

        // entrySet view (MOST IMPORTANT)
        System.out.println("\nIterating over entries:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // remove
        map.remove(103);
        System.out.println("\nAfter remove(103): " + map);
    }
}

