package CollectionFramework.ListInterface;

import java.io.Serializable;
import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        // 1. Different constructors
        List<String> defaultList = new ArrayList<>();
        List<String> capacityList = new ArrayList<>(20);
        List<String> fromCollection = new ArrayList<>(defaultList);


        // 2. Allows duplicates, nulls, preserves insertion order
        ArrayList<Object> list = new ArrayList<>();
        list.add("A");
        list.add(10);  //heterogeneous
        list.add("A");   //duplicate
        list.add(null); //null allowed
        System.out.println("List after basic add:"+list);

        // 3. Index-based operations (get, set, add at index, remove at index)
        System.out.println("Element at index 1 (get): "+list.get(1));

        list.set(1, 20);  // replace element at index 1
        System.out.println("After set(1, 20): " + list);

        list.add(2, "MIDDLE"); // insert in the middle (internal shifting happens)
        System.out.println("After add(2, \"MIDDLE\"): " + list);

        list.remove(3); // remove element at index 3 (again causes shifting)
        System.out.println("After remove(3): " + list);

        // 4. Searching (indexOf, lastIndexOf)
        System.out.println("indexOf(\"A\"): " + list.indexOf("A"));
        System.out.println("indexOf(\"A\"): " + list.indexOf("A"));
        System.out.println("lastIndexOf(\"A\"): " + list.lastIndexOf("A"));

        // 5. Iteration using Iterator
        System.out.println("Iterating using iterator: ");
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        // 6. Iteration using ListIterator (bi-directional)
        ListIterator<Object> listIterator = list.listIterator();
        System.out.println("Going fwd with ListIterator: ");
        while (listIterator.hasNext()) {System.out.print(listIterator.next()+" ");}
        System.out.println();
        System.out.println("Going back with ListIterator: ");
        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous()+" ");
        }
        System.out.println();

        // 7. Check for Serializable, Cloneable, RandomAccess
        System.out.println("ArrayList is instanceof Serializable: "+(list instanceof Serializable));
        System.out.println("list instanceof Cloneable    : " + (list instanceof Cloneable));
        System.out.println("list instanceof RandomAccess : " + (list instanceof RandomAccess));

        // 8. Getting synchronized version of ArrayList
        List<Object> syncList = Collections.synchronizedList(list);
        System.out.println("Synchronized List created using Collections.synchronizedList(list)");

        // Note: For thread safety when iterating syncList, we should synchronize on it:
        synchronized (syncList) {
            System.out.println("Iterating syncList list safely: ");
            for (Object o : syncList) {
                System.out.print(o+" ");
            }
            System.out.println();
        }


    }

}
