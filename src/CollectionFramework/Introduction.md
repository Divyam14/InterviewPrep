# Introduction to Collections Framework (Java)

## Arrays Overview

* An **array** is an indexed collection of a fixed number of elements of the **same data type**.
* Main advantage: represents many elements using a single variable, improving code readability.

### Limitations of Arrays

1. **Fixed Size**: Once created, the size cannot be increased or decreased.
2. **Homogeneous Elements Only**: Arrays can store only same‑type elements.
3. **Limited Flexibility**: Lack of built‑in methods; developers must write logic manually.
4. Arrays can store both **primitive types and objects**.

### Example Issue

```java
Student[] s = new Student[10000];
s[0] = new Student();      // valid
s[1] = new Customer();     // invalid - different type
```

### Using Object[] as a Workaround

```java
Object[] arr = new Object[10000];
arr[0] = new Student();
arr[1] = new Customer();   // valid
```

But this still keeps the fixed-size limitation and lacks ready-made utility methods.

---

## Need for Collections

To overcome array limitations, Java provides the **Collections Framework**.

### Advantages of Collections

1. **Growable in Nature**: Size can increase or decrease dynamically.
2. Can store **homogeneous or heterogeneous** objects.
3. Implemented using **standard data structures** → rich set of built‑in utility methods.

---

## Arrays vs Collections

| Feature            | Arrays          | Collections                 |
| ------------------ | --------------- | --------------------------- |
| Size               | Fixed           | Growable                    |
| Memory Efficiency  | Not recommended | Recommended                 |
| Performance        | High            | Lower than arrays           |
| Data Type          | Homogeneous     | Homogeneous & heterogeneous |
| Built‑in Methods   | None / very few | Rich API support            |
| Primitives Support | Yes             | No (objects only)           |

---

This section covers the basics of why Collections are needed compared to arrays. Provide the next snippet when ready.

---

## Collection Framework Overview

### What is a Collection?

* A **collection** represents a group of individual objects treated as a single entity.
* Acts as the **root interface** of the Java Collections Framework.
* Defines common operations applicable to all collection types.
* No concrete class implements `Collection` directly.

### Collection Framework

The Java Collection Framework provides various classes and interfaces to work with object groups efficiently.

**Java vs C++:**

* Java → *Collection Framework*
* C++ → *Containers / STL (Standard Template Library)*

### Key Interfaces in the Collection Framework (9 Total)

1. **Collection**
2. **List**
3. **Set**
4. **SortedSet**
5. **NavigableSet**
6. **Queue**
7. **Map**
8. **SortedMap**
9. **NavigableMap**

---

## Brief Overview of Key Collection Framework Interfaces

### **1. Collection**

* Root interface of the Collections Framework.
* Represents a group of individual objects.
* Defines common, general-purpose methods.
* No class implements Collection directly.

---

### **2. List**

* Child interface of Collection.
* Allows **duplicate elements**.
* **Preserves insertion order**.
* Index-based operations supported.

---

### **3. Set**

* Child interface of Collection.
* **Does not allow duplicates**.
* **Does not preserve insertion order**.

---

### **4. SortedSet**

* Child interface of Set.
* Stores **unique elements in sorted order**.
* Sorting can be natural or custom (Comparator).

---

### **5. NavigableSet**

* Child of SortedSet.
* Adds navigation methods like `lower()`, `floor()`, `ceiling()`, `higher()`.

---

### **6. Queue**

* Child of Collection.
* Used to hold elements **prior to processing** (FIFO typically).

---

### **Note:** Collection, List, Set, SortedSet, NavigableSet, Queue → hold *individual objects*.

---

### **7. Map**

* Not a child of Collection.
* Stores **key–value pairs**.
* Duplicate keys not allowed; duplicate values allowed.

---

### **8. SortedMap**

* Child of Map.
* Stores key–value pairs **sorted by keys**.

---

### **9. NavigableMap**

* Child of SortedMap.
* Adds navigation methods.

---

## Difference: Collection vs Collections

* **Collection** → *interface* representing a group of objects.
* **Collections** → *utility class* (`java.util.Collections`) containing static helper methods (sorting, searching, synchronization, etc.).

---

## Legacy Classes in Collections Framework

* **Enumeration** (cursor)
* **Dictionary** (abstract class)
* **Vector**
* **Stack**
* **Hashtable**
* **Properties**

---

Ready for the next snippet!
