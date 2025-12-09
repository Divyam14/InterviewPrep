package CollectionFramework.SetInterface;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetSortStringLength {

    //Sort by String Length (then lexicographically)


    public static void main(String[] args) {
        Comparator<String> lengthThenAlpha = (s1,s2) -> {
            int lenDiff = s1.length() - s2.length();
            if (lenDiff != 0) {
                return lenDiff;
            }return s1.compareTo(s2);
        };

        Set<String> set = new TreeSet<>(lengthThenAlpha);

        set.add("bbb");
        set.add("a");
        set.add("cc");
        set.add("dddd");
        set.add("bb");

        System.out.println("TreeSet (length then alpha): " + set);
    }

}
