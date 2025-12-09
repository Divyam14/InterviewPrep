# List Interface — Ultimate Interview Revision Notes (Java Collections Framework)

## 1. Introduction

The **List** interface is a child of the `Collection` interface and represents an **ordered**, **indexed**, and **duplicate-friendly** collection.

### Key Characteristics

* **Insertion order preserved**
* **Duplicates allowed**
* **Heterogeneous objects allowed** (except in sorted structures like TreeSet/TreeMap)
* **Index-based access** (0-based)
* All classes implementing List are **Serializable**, **Cloneable**, and most implement **RandomAccess** (ArrayList, Vector) for fast retrieval.

---

## 2. List Hierarchy (ASCII Diagram)

```
              Collection
                   |
                 List
      /------------|-------------\
 ArrayList     LinkedList        Vector
                                    |
                                  Stack
```

---

## 3. Methods in List Interface

List introduces several index-based methods in addition to Collection methods.

### Index-Based Operations

* `void add(int index, Object o)`
* `boolean addAll(int index, Collection c)`
* `Object get(int index)`
* `Object remove(int index)`
* `Object set(int index, Object o)`

### Searching

* `int indexOf(Object o)`
* `int lastIndexOf(Object o)`

### Iteration

* `ListIterator listIterator()`
* `ListIterator listIterator(int index)`

---

# 4. ArrayList — Complete Notes

ArrayList is the **most commonly used** implementation of List.

### Key Features

* Underlying DS → **Resizable (Growable) Array**
* Fast retrieval (index-based)
* Slower insertions/deletions in middle
* Allows duplicates and nulls

---

## ArrayList ASCII Internal Diagram

```
Index:    0     1     2     3     4     5  ...
         +-----+-----+-----+-----+-----+-----+
         | Obj | Obj | Obj | Obj | Obj | ... |
         +-----+-----+-----+-----+-----+-----+

When full → grows automatically:
newCapacity = (oldCapacity * 3/2) + 1
```

---

## ArrayList Constructors

1. `ArrayList()` → Default initial capacity = **10**
2. `ArrayList(int initialCapacity)`
3. `ArrayList(Collection c)` → Creates list with elements of c

---

## ArrayList Important Points

* Best for **retrieval** operations
* Worst for **insert/delete** in middle
* Implements **RandomAccess** → supports O(1) get()
* **Not thread-safe** by default
* Best for **retrieval** operations
* Worst for **insert/delete** in middle
* Implements **RandomAccess** → supports O(1) get()

---

## Getting Synchronized Version of ArrayList (VERY IMPORTANT)

ArrayList is **not thread-safe**. To make it thread-safe, Java provides utility methods via the `Collections` class.

### Method

```java
public static List synchronizedList(List l);
```

### Example

```java
import java.util.*;

List list = new ArrayList();
List syncList = Collections.synchronizedList(list);
```

### Important Notes (Interview Favorites)

* The returned list is **thread-safe**
* Synchronization happens at the **method level**
* Performance is lower than normal ArrayList due to locking
* Same approach applies for Set and Map:

```java
Collections.synchronizedSet(Set s);
Collections.synchronizedMap(Map m);
```

---

# 5. LinkedList — Complete Notes

LinkedList is a **doubly linked list** implementation.

### Key Features

* Best for frequent insertions/deletions
* Worst for random access (O(n) retrieval)
* Implements **Deque**, so it supports stack/queue operations
* Allows null and duplicates

### LinkedList Internal Structure

```
NULL <- [prev | data | next] <-> [prev | data | next] <-> [prev | data | next] -> NULL
```

---

## LinkedList Constructors

1. `LinkedList()`
2. `LinkedList(Collection c)`

---

## LinkedList Special Methods

* `void addFirst(Object o)`
* `void addLast(Object o)`
* `Object getFirst()`
* `Object getLast()`
* `Object removeFirst()`
* `Object removeLast()`

---

# 6. Vector — Complete Notes (Legacy)

Vector is a **thread-safe**, legacy alternative to ArrayList.

### Key Features

* Every method is **synchronized**
* Slower due to synchronization
* Allows duplicates & nulls
* Capacity doubles when full

### ASCII Diagram for Vector Growth

```
oldCapacity = n
newCapacity = n * 2
```

---

## Vector Constructors

1. `Vector()` → default capacity = 10
2. `Vector(int initialCapacity)`
3. `Vector(int initialCapacity, int capacityIncrement)`
4. `Vector(Collection c)`

---

## Vector-Specific Methods

* `void addElement(Object o)`
* `boolean removeElement(Object o)`
* `void removeElementAt(int index)`
* `void removeAllElements()`
* `Object firstElement()`
* `Object lastElement()`
* `Object elementAt(int index)`

---

## ArrayList vs Vector (Interview Table)

| Feature         | ArrayList | Vector                         |
| --------------- | --------- | ------------------------------ |
| Synchronization | No        | Yes (all methods synchronized) |
| Performance     | Faster    | Slower                         |
| Capacity Growth | 1.5x      | 2x                             |
| Legacy?         | No        | Yes                            |

---

# 7. Stack — Complete Notes

Stack is a **LIFO** structure built on top of Vector.

### Stack Diagram

```
    +---------+
    |  Top    | <-- push()
    +---------+
    |         |
    |         |
    |         |
    +---------+
      Bottom
```

---

## Stack Methods

* `push(Object o)`
* `Object pop()`
* `Object peek()`
* `boolean empty()`
* `int search(Object o)`

---

# 8. Cursors — Enumerator, Iterator, ListIterator

Used to traverse list elements.

## Enumeration (Legacy)

* Forward-only
* Read-only
* Used in Vector

## Iterator

* Forward-only
* Read & remove support
* `remove()` allowed

## ListIterator

* Bidirectional
* Can add, set, remove
* Only for List implementations

### ListIterator Diagram

```
<-- previous()      [cursor]      next() -->
```

---

# 9. Advanced & Tricky List Concepts (Interview Gold)

This section covers concepts **frequently asked in real interviews** but easy to miss during preparation.

---

## 9.1 Fail-Fast vs Fail-Safe Iterators

### Fail-Fast (Most List implementations)

* **ArrayList, LinkedList, Iterator, ListIterator** are *fail-fast*
* Structural modification during iteration → `ConcurrentModificationException`

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");

for (String s : list) {
    list.add("C");   // ❌ ConcurrentModificationException
}
```

### Fail-Safe

* Legacy cursors like **Enumeration** (Vector)
* Iterates over a copy or synchronized structure
* No exception, but may not reflect latest changes

> 🔑 Interview line: *“Fail-fast iterators throw CME to avoid inconsistent traversal.”*

---

## 9.2 Arrays.asList() vs List.of() vs new ArrayList<>()

### Arrays.asList()

```java
List<Integer> l = Arrays.asList(1, 2, 3);
l.set(0, 10); // ✅ allowed
l.add(4);     // ❌ UnsupportedOperationException
```

* Fixed-size list backed by array
* Size cannot change
* Allows nulls

### List.of() (Java 9+)

```java
List<Integer> l = List.of(1, 2, 3);
```

* Immutable list
* No add, remove, set
* Nulls NOT allowed

### new ArrayList<>()

```java
List<Integer> l = new ArrayList<>(Arrays.asList(1, 2, 3));
l.add(4); // ✅ fully mutable
```

| Method        | Mutable | Size Change | Nulls |
| ------------- | ------- | ----------- | ----- |
| Arrays.asList | Partial | ❌ No        | ✅ Yes |
| List.of       | ❌ No    | ❌ No        | ❌ No  |
| new ArrayList | ✅ Yes   | ✅ Yes       | ✅ Yes |

---

## 9.3 subList() Behavior — BACKED by Original List

```java
List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
List<Integer> sub = list.subList(1, 4); // [2, 3, 4]

sub.clear();
System.out.println(list); // [1, 5]
```

### Key Points

* `subList()` does NOT create a new list
* It is a **view backed by the original list**
* Changes reflect both ways

> 🔥 Very common interview trap question

---

## 9.4 Collections.synchronizedList vs CopyOnWriteArrayList

### synchronizedList()

* Uses **method-level synchronization**
* Iterator must be manually synchronized
* Blocking behavior during iteration

```java
List list = Collections.synchronizedList(new ArrayList());
```

### CopyOnWriteArrayList (java.util.concurrent)

* Thread-safe without explicit synchronization
* Iterator is **fail-safe**
* Writes are expensive (creates new copy)

```java
List<Integer> list = new CopyOnWriteArrayList<>();
```

| Feature         | synchronizedList | CopyOnWriteArrayList |
| --------------- | ---------------- | -------------------- |
| Iteration       | Blocking         | Non-blocking         |
| Writes          | Cheaper          | Expensive            |
| Read-heavy apps | ❌                | ✅ Best               |

---

## 9.5 Time Complexity Comparison (Must-Remember)

| Operation      | ArrayList | LinkedList |
| -------------- | --------- | ---------- |
| get(i)         | O(1)      | O(n)       |
| add(end)       | O(1)*     | O(1)       |
| add(middle)    | O(n)      | O(1)       |
| remove(middle) | O(n)      | O(1)       |

* Amortized time complexity

---

✅ **You are now fully interview-ready on List interface**

# End of Ultimate List Interface Notes

This file is designed for **fast revision**, **deep understanding**, and **interview preparation**.
