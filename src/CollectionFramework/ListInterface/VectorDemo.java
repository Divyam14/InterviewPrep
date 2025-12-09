package CollectionFramework.ListInterface;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.RandomAccess;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // 1. Constructors
        Vector<Object> v1 = new Vector<>();           // default capacity = 10
        Vector<Object> v2 = new Vector<>(5);          // initial capacity = 5
        Vector<Object> v3 = new Vector<>(5, 2);       // capacity increment = 2
        Vector<Object> v4 = new Vector<>(v1);         // from another collection

        // 2. Basic features: duplicates, nulls, insertion order
        Vector<Object> v = new Vector<>();
        System.out.println("Initial capacity: " + v.capacity());

        for (int i = 1; i <= 10; i++) {
            v.addElement(i);  // Vector-specific method
        }
        System.out.println("Vector after adding 10 elements: " + v);
        System.out.println("Capacity after 10 elements: " + v.capacity());

        v.addElement("A");   // triggers growth
        System.out.println("After adding one more element: " + v);
        System.out.println("Capacity after growth: " + v.capacity()); // usually 20 (2x)

        // 3. Vector-specific methods
        v.removeElement(5);
        System.out.println("After removeElement(5): " + v);

        v.removeElementAt(0);
        System.out.println("After removeElementAt(0): " + v);

        System.out.println("firstElement(): " + v.firstElement());
        System.out.println("lastElement():  " + v.lastElement());
        System.out.println("elementAt(2):   " + v.elementAt(2));

        // 4. Enumeration cursor (legacy)
        System.out.print("Iterating using Enumeration: ");
        Enumeration<Object> e = v.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
        System.out.println();

        // 5. Thread-safety / marker interfaces
        System.out.println("v instanceof Serializable : " + (v instanceof Serializable));
        System.out.println("v instanceof Cloneable    : " + (v instanceof Cloneable));
        System.out.println("v instanceof RandomAccess : " + (v instanceof RandomAccess));

        // Note: All Vector methods are synchronized → thread-safe but slower.
    }
}
