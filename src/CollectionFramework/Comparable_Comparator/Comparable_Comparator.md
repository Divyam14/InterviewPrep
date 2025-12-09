# Comparable & Comparator — Ultimate Interview Prep Notes (Java)

> These two interfaces are **guaranteed interview questions** whenever Collections, sorting, or custom objects are discussed.

        ---

        ## 1. Why Comparable & Comparator Exist

Java needs a way to **compare objects** when:

        * Sorting collections (`Collections.sort`, `TreeSet`, `TreeMap`)
* Maintaining ordered data structures

There are **two strategies**:

        1. Natural Ordering → `Comparable`
        2. Custom Ordering → `Comparator`

        ---

        ## 2. Comparable Interface

### Definition

`Comparable` is present in `java.lang` package.

        ```java
public interface Comparable<T> {
    int compareTo(T o);
}
```

        ### Purpose

Defines the **natural ordering** of objects.

        > ✅ Interview one-liner: *Comparable is used to define default sorting logic inside the class itself.*

        ---

        ## 3. How compareTo() Works

```java
obj1.compareTo(obj2)
```

        | Return Value | Meaning      |
        | ------------ | ------------ |
        | Negative     | obj1 < obj2  |
        | Zero         | obj1 == obj2 |
        | Positive     | obj1 > obj2  |

        ---

        ## 4. Comparable Example — Sorting Custom Objects

```java
import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee e) {
        return this.id - e.id; // sorting by id
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(3, "A"));
        list.add(new Employee(1, "B"));
        list.add(new Employee(2, "C"));

        Collections.sort(list);
        System.out.println(list); // sorted by id
    }
}
```

        ---

        ## 5. Important Rules of Comparable (INTERVIEW FAVORITE)

1. All elements must be **mutually comparable**
        2. Sorting logic is **fixed** (only one natural order)
        3. `compareTo()` must be **consistent with equals()`**

        ❌ Violations cause:

        * `ClassCastException`
        * Unexpected duplicate removal in `TreeSet`

        ---

        ## 6. Comparator Interface

### Definition

`Comparator` is present in `java.util` package.

        ```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```

        ### Purpose

Defines **custom sorting logic external to the class**.

        > ✅ Interview one-liner: *Comparator is used when we cannot or do not want to modify the class.*

        ---

        ## 7. Comparator Example — Custom Sorting

### Sort Employee by Name

```java
import java.util.*;

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}

// Usage
Collections.sort(list, new NameComparator());
        ```

        ---

        ### Comparator using Lambda (Java 8+)

```java
Collections.sort(list, (e1, e2) -> e2.id - e1.id); // descending by id
        ```

        ---

        ## 8. Comparable vs Comparator — MUST REMEMBER TABLE

| Feature              | Comparable  | Comparator |
        | -------------------- | ----------- | ---------- |
        | Package              | java.lang   | java.util  |
        | Method               | compareTo() | compare()  |
        | Sorting Logic        | Natural     | Custom     |
        | Inside Class         | ✅ Yes       | ❌ No       |
        | Multiple Sort Orders | ❌ No        | ✅ Yes      |

        ---

        ## 9. TreeSet / TreeMap Behavior (CRITICAL)

### TreeSet + Comparable

```java
Set<Employee> set = new TreeSet<>();
```

        * Uses `compareTo()`

        ### TreeSet + Comparator

```java
Set<Employee> set = new TreeSet<>(new NameComparator());
```

        * Uses `compare()`

        🔴 If `compare()` or `compareTo()` returns `0`, elements are treated as **duplicates**.

        ---

        ## 10. Common Interview Traps

### Trap 1: compareTo vs equals

```java
compareTo() == 0  ✅ → duplicate in TreeSet
        .equals() == false ❌ still treated as duplicate
```

        > TreeSet relies on **comparison**, not equals

---

        ### Trap 2: Null Handling

* `Comparable` → `NullPointerException`
        * Comparator can be written to **handle nulls safely**

        ```java
Comparator<String> nullSafe = Comparator.nullsLast(String::compareTo);
```

        ---

        ## 11. When to Use What (INTERVIEW ANSWER)

✅ Use **Comparable** when:

        * Single natural ordering exists
* You control the class source code

✅ Use **Comparator** when:

        * Multiple sorting strategies are needed
* Class is third-party or immutable

---

        ## 12. One-Line Interview Answers

* *Comparable defines natural ordering inside the class.*
        * *Comparator defines custom ordering externally.*
        * *TreeSet uses compareTo or Comparator to detect duplicates.*

        ---

        ✅ **You are now fully interview-ready for Comparable & Comparator**

        # End of Ultimate Comparable & Comparator Notes
