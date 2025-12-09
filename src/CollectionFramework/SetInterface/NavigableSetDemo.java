package CollectionFramework.SetInterface;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {
    public static void main(String[] args) {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(15);
        set.add(25);

        System.out.println("Original set: " + set); // [5, 10, 15, 20, 25]

        System.out.println("ceiling(12): " + set.ceiling(12));   // 15
        System.out.println("floor(12): " + set.floor(12));       // 10
        System.out.println("higher(20): " + set.higher(20));     // 25
        System.out.println("lower(20): " + set.lower(20));       // 15

        System.out.println("pollFirst(): " + set.pollFirst());   // 5
        System.out.println("pollLast(): " + set.pollLast());     // 25

        System.out.println("After polling: " + set);             // [10, 15, 20]

        System.out.println("Descending set view: " + set.descendingSet()); // [20, 15, 10]
    }
}

