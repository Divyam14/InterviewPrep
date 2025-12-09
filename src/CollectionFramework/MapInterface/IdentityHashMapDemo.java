package CollectionFramework.MapInterface;

import java.util.*;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> identityMap = new IdentityHashMap<>();

        String s1 = new String("A");
        String s2 = new String("A"); // different objects, same content

        hashMap.put(s1, "hash-1");
        hashMap.put(s2, "hash-2");

        identityMap.put(s1, "id-1");
        identityMap.put(s2, "id-2");

        System.out.println("HashMap size:        " + hashMap.size());        // 1
        System.out.println("HashMap content:     " + hashMap);

        System.out.println("IdentityHashMap size:" + identityMap.size());    // 2
        System.out.println("IdentityHashMap:     " + identityMap);
    }
}

