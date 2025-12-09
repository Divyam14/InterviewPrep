package CollectionFramework.MapInterface;

import java.util.*;

public class NavigableMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(10, "ten");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");

        System.out.println("Map: " + map);

        System.out.println("ceilingKey(25): " + map.ceilingKey(25)); // 30
        System.out.println("floorKey(25):   " + map.floorKey(25));   // 20
        System.out.println("higherKey(40):  " + map.higherKey(40));  // 50
        System.out.println("lowerKey(40):   " + map.lowerKey(40));   // 30

        System.out.println("pollFirstEntry(): " + map.pollFirstEntry());
        System.out.println("pollLastEntry():  " + map.pollLastEntry());
        System.out.println("After polls:       " + map);

        System.out.println("descendingMap():   " + map.descendingMap());
    }
}

