# Map Interface — Ultimate Interview Revision Notes (Java Collections Framework)

> **Map is the MOST ASKED topic** in Java interviews. These notes are optimized for **deep clarity + quick revision + tricky interview angles**.

---

## 1. What is a Map?

A **Map** represents a group of objects as **key–value pairs**.

### Key Characteristics

* **Keys are unique**, values may be duplicated
* Each key maps to **at most one value**
* Map is **NOT a child of Collection** interface
* Keys must be immutable (best practice)

> ✅ Interview one-liner: *Map stores data as key–value pairs, where keys must be unique.*

---

## 2. Map Interface Hierarchy (ASCII Diagram)

```
                Map
                 |
      --------------------------------
      |              |               |
   HashMap     SortedMap        ConcurrentMap
      |              |               |
 LinkedHashMap     NavigableMap   ConcurrentHashMap
                       |
                     TreeMap
```

---

## 3. Core Map Methods (VERY IMPORTANT)

### Put / Get Operations

* `Object put(K key, V value)`
* `Object get(Object key)`
* `void putAll(Map m)`

### Remove & Check

* `Object remove(Object key)`
* `boolean containsKey(Object key)`
* `boolean containsValue(Object value)`

### Utility

* `int size()`
* `boolean isEmpty()`
* `void clear()`

---

## 4. Map Views (INTERVIEW FAVORITE)

A Map provides **3 views**:

```java
Set<K> keySet();
Collection<V> values();
Set<Map.Entry<K,V>> entrySet();
```

### Entry Interface

```java
interface Entry<K,V> {
    K getKey();
    V getValue();
    V setValue(V value);
}
```

---

# 5. HashMap — Complete Notes

## Key Features

* Underlying DS → **Hash Table**
* **No insertion order preserved** (Java 7 and below)
* Allows **1 null key** and **multiple null values**
* Not synchronized (not thread-safe)
* Implements Serializable & Cloneable

---

## HashMap Internal Working (CRITICAL)

### Step-by-Step put(key, value)

1. `hashCode()` of key is called
2. Hash is converted to bucket index
3. If bucket empty → new entry inserted
4. If collision → compared using `equals()`

### Collision Handling

```
Before Java 8: Linked List
After Java 8:
- Linked List → Red-Black Tree (if bucket size > 8)
```

---

## HashMap Internal Diagram

```
Key → hashCode() → Index
                    |
          [Node(key,value)] → [Node] → [Node]
```

---

## HashMap Constructors

* `HashMap()` → default capacity 16, load factor 0.75
* `HashMap(int initialCapacity)`
* `HashMap(int initialCapacity, float loadFactor)`
* `HashMap(Map m)`

---

## HashMap Load Factor (INTERVIEW GOLD)

```
Threshold = capacity × loadFactor
Default: 16 × 0.75 = 12
```

When size > threshold → **rehashing occurs**.

---

# 6. LinkedHashMap — Complete Notes

LinkedHashMap is a **child of HashMap**.

## Key Features

* Maintains **insertion order**
* HashMap + Doubly Linked List
* Slightly slower, more memory

### Order Types

* Insertion-order (default)
* Access-order (LRU Cache usage)

```java
new LinkedHashMap<>(16, 0.75f, true); // access-order
```

---

## LinkedHashMap Diagram

```
Hash Table + Doubly Linked List
[A] → [C] → [B]
```

---

# 7. SortedMap Interface

SortedMap stores entries **sorted by keys**.

### Important Methods

* `firstKey()`
* `lastKey()`
* `headMap(k)`
* `tailMap(k)`
* `subMap(k1, k2)`

---

# 8. TreeMap — Complete Notes

TreeMap implements **NavigableMap**.

## Key Features

* Underlying DS → **Red-Black Tree**
* Entries sorted by key
* No null keys allowed
* Duplicate keys not allowed

---

## TreeMap Sorting

* Natural ordering (Comparable)
* Custom ordering (Comparator)

```java
new TreeMap<>(Comparator.reverseOrder());
```

---

## Null Handling in TreeMap

❌ null key → `NullPointerException`
✅ null values allowed

---

# 9. NavigableMap Interface

### Important Methods

* `ceilingKey(k)`
* `floorKey(k)`
* `higherKey(k)`
* `lowerKey(k)`
* `pollFirstEntry()`
* `pollLastEntry()`
* `descendingMap()`

---

# 10. HashMap vs LinkedHashMap vs TreeMap (Interview Table)

| Feature     | HashMap    | LinkedHashMap      | TreeMap        |
| ----------- | ---------- | ------------------ | -------------- |
| Order       | ❌ No       | ✅ Insertion/Access | ✅ Sorted       |
| Null Keys   | ✅ 1        | ✅ 1                | ❌ No           |
| DS          | Hash Table | Hash + DLL         | Red-Black Tree |
| Performance | 🔥 Fastest | ⚡ Medium           | 🐢 Slow        |

---

# 11. Fail-Fast Behavior in Map

```java
for (Map.Entry e : map.entrySet()) {
   map.put(4,"X"); // ConcurrentModificationException
}
```

---

# 12. Thread Safety & Synchronization

## synchronizedMap

```java
Map m = Collections.synchronizedMap(new HashMap());
```

## ConcurrentHashMap

* Thread-safe
* Segment-based locking (Java 7)
* Fine-grained CAS locking (Java 8+)

---

# 13. equals() & hashCode() Contract (VERY IMPORTANT)

✅ If two keys are equal:

* `equals()` must return true
* `hashCode()` must be same

❌ Broken contract → data loss / duplicates

---

# 14. Common Interview Traps

1. Why Map is not Collection?
2. HashMap allows null but Hashtable doesn’t
3. Why HashMap key should be immutable
4. What happens if hashCode changes after insert?

---

# ✅ Final Verdict

You are now **interview-ready for Map interface**.

This file covers:

* Complete theory
* Internals & diagrams
* Java 7 vs Java 8 behavior
* Traps & one-liners

# End of Ultimate Map Interface Notes
