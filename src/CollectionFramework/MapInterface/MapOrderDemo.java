package CollectionFramework.MapInterface;

import java.util.*;

public class MapOrderDemo {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        // same data in all
        hashMap.put(3, "C");
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(null, "NULL_KEY_HASHMAP");  // allowed in HashMap

        linkedHashMap.put(3, "C");
        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");
        linkedHashMap.put(null, "NULL_KEY_LHM"); // allowed in LinkedHashMap

        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");
        // treeMap.put(null, "X"); // ❌ NullPointerException at runtime

        System.out.println("HashMap (no order):      " + hashMap);
        System.out.println("LinkedHashMap (insertion): " + linkedHashMap);
        System.out.println("TreeMap (sorted by key): " + treeMap);
    }
}

