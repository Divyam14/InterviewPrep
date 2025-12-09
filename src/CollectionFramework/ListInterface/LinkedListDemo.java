package CollectionFramework.ListInterface;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {

//        1. Constructors
        LinkedList<Object> list = new LinkedList<>();
        List<Object> base = List.of("X", "Y", "Z");
        LinkedList<Object> fromCollection = new LinkedList<>(base);

        System.out.println("LinkedList from collection :"+fromCollection);

        // 2. Basic features: duplicates, null, insertion order
        list.add("ashok");
        list.add(30);
        list.add(null);
        list.add("ashok");  // duplicate
        System.out.println("Initial LinkedList: " + list);

        // 3. Insertion / deletion in the middle (good use-case)
        list.add(1, "MIDDLE");
        System.out.println("After add(1, \"MIDDLE\"): " + list);

        list.remove(2);
        System.out.println("After remove(2): " + list);

        // 4. Special LinkedList methods (stack/queue style)
        list.addFirst("FIRST");
        list.addLast("LAST");
        System.out.println("After addFirst/addLast: " + list);

        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast():  " + list.getLast());

        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst/removeLast: " + list);

        // 5. Check for Serializable, Cloneable, RandomAccess
        System.out.println("list instanceof Serializable : " + (list instanceof Serializable));
        System.out.println("list instanceof Cloneable    : " + (list instanceof Cloneable));
        System.out.println("list instanceof RandomAccess : " + (list instanceof java.util.RandomAccess));
    }
}
