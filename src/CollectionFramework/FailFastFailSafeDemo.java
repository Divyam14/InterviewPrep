package CollectionFramework;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastFailSafeDemo {

    public static void main(String[] args) {
        System.out.println("=== Fail-Fast Demo (ArrayList) ===");
        failFastDemo();

        System.out.println("\n=== Fail-Safe Demo (CopyOnWriteArrayList) ===");
        failSafeListDemo();

        System.out.println("\n=== Fail-Safe Demo (ConcurrentHashMap) ===");
        failSafeMapDemo();
    }

    // ----------------- FAIL-FAST -----------------
    private static void failFastDemo() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3);

        try {
            for (Integer i : list) {
                System.out.println("Current element: " + i);
                if (i == 2) {
                    System.out.println("Modifying list inside loop (add 4)...");
                    list.add(4); // Structural modification → ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught exception: " + e);
        }

        System.out.println("Final list: " + list);
    }

    // ----------------- FAIL-SAFE (CopyOnWriteArrayList) -----------------
    private static void failSafeListDemo() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer i : list) {
            System.out.println("Current element: " + i);
            if (i == 2) {
                System.out.println("Modifying list inside loop (add 4)...");
                list.add(4); // No exception; iterator works on snapshot
            }
        }

        System.out.println("Final list: " + list); // [1, 2, 3, 4]
    }

    // ----------------- FAIL-SAFE (ConcurrentHashMap) -----------------
    private static void failSafeMapDemo() {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Current entry: " + entry);
            if (entry.getKey() == 2) {
                System.out.println("Modifying map inside loop (put 4 -> D)...");
                map.put(4, "D"); // No CME, iterator is weakly consistent
            }
        }

        System.out.println("Final map: " + map);
    }
}
