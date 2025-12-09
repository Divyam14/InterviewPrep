package CollectionFramework.MapInterface;

import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();

        table.put("A", 1);
        table.put("B", 2);
        table.put("C", 3);

        System.out.println("Hashtable: " + table);

        // ❌ Uncomment to see NPE:
        // table.put(null, 10);    // NullPointerException
        // table.put("X", null);   // NullPointerException

        // Enumeration (legacy cursor)
        System.out.println("\nIterating with Enumeration:");
        Enumeration<String> e = table.keys();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            System.out.println(key + " -> " + table.get(key));
        }
    }
}

