# Set Interface — Ultimate Interview Revision Notes (Java Collections Framework)

## 1. Introduction

The **Set** interface is a child of the `Collection` interface. It represents a group of **unique elements**, meaning **duplicates are not allowed**.

### Key Characteristics

* **Duplicate elements NOT allowed**
* Order depends on implementation
* At most **one null** element (HashSet, LinkedHashSet)
* All major Set implementations are **Serializable**, **Cloneable**

> ✅ Interview one-liner: *Set follows mathematical set semantics — uniqueness is enforced using equals() and hashCode().*

---

## 2. Set Interface Hierarchy (ASCII Diagram)

```
           Collection
                |
               Set
      /----------|-----------\
  HashSet                      SortedSet
    |                              |
LinkedHashSet                 NavigableSet
                                   |
                                 TreeSet
```

---

## 3. Set Interface — Important Methods

Set does **not add new methods** beyond Collection. It relies on:

* `boolean add(Object o)`
* `boolean addAll(Collection c)`
* `boolean remove(Object o)`
* `boolean contains(Object o)`
* `int size()`
* `Iterator iterator()`

> 🔥 Trick question: *Why no index-based methods?* → Because Set is unordered.

---

# 4. HashSet — Complete Notes

HashSet is the **most commonly used Set implementation**.

## Key Features

* Underlying DS → **Hash Table**
* **No insertion order preserved**
* Allows **one null** element
* Duplicate detection uses **hashCode() + equals()**
* Best for **fast search, insert, delete**

---

## HashSet Internal Diagram (ASCII)

```
Object → hashCode() → Bucket Index
                    |
        [Node] → [Node] → [Node]   (collision handled by linked list / tree)
```

---

## How HashSet Prevents Duplicates (INTERVIEW FAVORITE)

1. Calls `hashCode()`
2. Identifies bucket
3. Uses `equals()` to check duplicates

```java
class Employee {
    int id;
    public boolean equals(Object o) { ... }
    public int hashCode() { ... }
}
```

> ✅ If both hashCode & equals match → duplicate rejected

---

## HashSet Constructors

* `HashSet()`
* `HashSet(int initialCapacity)`
* `HashSet(int initialCapacity, float loadFactor)`
* `HashSet(Collection c)`

Default:

* Capacity = 16
* Load factor = 0.75

---

# 5. LinkedHashSet — Complete Notes

LinkedHashSet is a **HashSet with insertion order preserved**.

## Key Features

* Hash table + doubly linked list
* Duplicate restriction same as HashSet
* Slightly slower than HashSet

### LinkedHashSet Diagram

```
Hash buckets + Insertion order list
[ A ] → [ C ] → [ B ]
```

---

## When to Use LinkedHashSet

✅ Need uniqueness + predictable order
✅ Cache-like behavior

---

# 6. SortedSet Interface

SortedSet is a child of Set.

## Features

* Elements stored in **sorted order**
* No duplicates
* Sorting can be:

    * Natural order (Comparable)
    * Custom order (Comparator)

### SortedSet Methods

* `first()`
* `last()`
* `headSet(e)`
* `tailSet(e)`
* `subSet(e1, e2)`

---

# 7. TreeSet — Complete Notes

TreeSet implements **NavigableSet**.

## Key Features

* Underlying DS → **Red-Black Tree**
* Elements sorted automatically
* No null allowed (since Java 7)
* Duplicate detection via **compareTo / compare**

---

## TreeSet Internal Diagram

```
           10
         /    \
        5      20
```

---

## TreeSet Constructors

* `TreeSet()` → natural sorting
* `TreeSet(Comparator c)` → custom sorting
* `TreeSet(Collection c)`

---

## TreeSet Sorting Rules (VERY IMPORTANT)

✅ All elements must be:

* Mutually comparable
* Same type

❌ Otherwise:

* `ClassCastException`
* `NullPointerException`

---

# 8. NavigableSet Interface

Adds navigation methods over SortedSet.

### Important Methods

* `ceiling(e)`
* `floor(e)`
* `higher(e)`
* `lower(e)`
* `pollFirst()`
* `pollLast()`
* `descendingSet()`

---

# 9. HashSet vs LinkedHashSet vs TreeSet (Interview Table)

| Feature     | HashSet    | LinkedHashSet      | TreeSet        |
| ----------- | ---------- | ------------------ | -------------- |
| Order       | ❌ No       | ✅ Insertion        | ✅ Sorted       |
| Nulls       | ✅ One      | ✅ One              | ❌ No           |
| DS          | Hash Table | Hash + Linked List | Red-Black Tree |
| Performance | 🔥 Fastest | ⚡ Medium           | 🐢 Slowest     |

---

# 10. Fail-Fast Behavior in Set

All modern Set implementations use **fail-fast iterators**.

```java
for (Integer i : set) {
    set.add(5); // CME
}
```

---

# 11. Common Interview Traps & Missing Concepts

## equals() vs compareTo()

* HashSet → uses `equals()`
* TreeSet → uses `compareTo()` or `Comparator`

> If compareTo returns 0 → elements treated as duplicates

---

## Can TreeSet contain null?

❌ No (throws NullPointerException)

---

## Why Set has no get(index)?

Because Set has **no positional access**.

---

# ✅ Final Verdict

You are now **100% interview-ready on Set interface**.

This file covers:

* Theory + internals
* Diagrams
* Constructors & traps
* Hashing & sorting logic
* Performance tradeoffs

# End of Ultimate Set Interface Notes
