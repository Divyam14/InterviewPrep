package CollectionFramework.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {

        // Duplicate and null handling
        Set<String> set = new HashSet<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");  // duplicate
        set.add(null); // allowed
        set.add(null); // duplicate null

        System.out.println("HashSet contents: " + set);
        //Order not guaranteed

        // Basic operations
        System.out.println("Contains B? " + set.contains("B"));
        set.remove("C");
        System.out.println("After removing C: " + set);
        System.out.println("Size: " + set.size());

        // Iteration (fail-fast)
        for (String s : set) {
            System.out.println("Element: " + s);
            // Uncommenting below will cause ConcurrentModificationException
            // set.add("X");
        }

    }
}
