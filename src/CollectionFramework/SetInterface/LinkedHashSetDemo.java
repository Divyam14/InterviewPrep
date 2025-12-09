package CollectionFramework.SetInterface;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

        set.add("A");
        set.add("C");
        set.add("B");
        set.add("A");   // duplicate
        set.add(null);  // allowed
        set.add(null);  // duplicate null

        System.out.println("LinkedHashSet contents: " + set);
        // Insertion order is preserved: [A, C, B, null]

        // Iterating shows insertion order
        for (String s : set) {
            System.out.println("Element: " + s);
        }
    }
}

