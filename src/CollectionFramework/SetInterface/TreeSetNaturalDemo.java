package CollectionFramework.SetInterface;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetNaturalDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("Z");
        set.add("A");
        set.add("K");
        set.add("B");
        set.add("A");   // duplicate -> ignored

        System.out.println("TreeSet (natural order): " + set);
        // Output: [A, B, K, Z]

        // Uncomment below line to see NullPointerException
        // set.add(null);

        // Iteration in sorted order
        for (String s : set) {
            System.out.println("Element: " + s);
        }
    }
}

