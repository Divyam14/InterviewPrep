package CollectionFramework.SetInterface;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetCustomComparatorDemo {

    public static void main(String[] args) {
        Comparator<Integer> desc = (a,b) -> b - a ;

        Set<Integer> set = new TreeSet<>(desc);

        set.add(10);
        set.add(5);
        set.add(20);
        set.add(15);

        System.out.println("TreeSet (custom descending order): " + set);
    }

}
