# Advanced Map Types — Hashtable, ConcurrentHashMap, WeakHashMap, IdentityHashMap

> These topics usually appear **after HashMap questions** and are used to judge **depth, not syntax**. Knowing them well clearly separates junior from senior candidates.

---

## 1. Where Does Hashtable Fit?

### ✅ Conceptual Placement

* **Hashtable** belongs to the **Map hierarchy**
* It is a **legacy predecessor of HashMap**
* Should be studied **after HashMap** and **before ConcurrentHashMap**

> 💡 Interview framing: *Hashtable is legacy, HashMap is modern non-thread-safe, ConcurrentHashMap is modern thread-safe.*

---

## 2. Hashtable — Complete & Interview-Oriented

### Key Characteristics

* Introduced in **Java 1.0** (legacy)
* **Thread-safe** (all methods synchronized)
* **No null key** and **no null values** allowed
* Extends `Dictionary` (legacy abstract class)
* Very **slow** due to coarse-grained locking

```java
Hashtable<String, Integer> ht = new Hashtable<>();
ht.put("A", 1);
ht.put(null, 2); // ❌ NullPointerException
```

---

### Hashtable vs HashMap (CLASSIC QUESTION)

| Feature     | Hashtable | HashMap    |
| ----------- | --------- | ---------- |
| Thread-safe | ✅ Yes     | ❌ No       |
| Null key    | ❌ No      | ✅ 1        |
| Null value  | ❌ No      | ✅ Multiple |
| Performance | 🐢 Slow   | 🔥 Fast    |
| Legacy      | ✅ Yes     | ❌ No       |

---

### Why Hashtable Is Obsolete

* Method-level synchronization locks entire table
* Blocks read operations
* Replaced by **ConcurrentHashMap**

> ✅ Interview line: *Hashtable is synchronized but not scalable.*

---

# 3. ConcurrentHashMap — DEEP DIVE (VERY IMPORTANT)

## Why ConcurrentHashMap?

Solves **HashMap (not thread-safe)** and **Hashtable (poor performance)** problems.

---

## Java 7 Working (SEGMENT LOCKING)

```
ConcurrentHashMap
   └── Segments (default 16)
        └── HashEntries
```

* Map divided into **segments**
* Each segment locked independently
* Multiple threads can modify different segments

---

## Java 8+ Working (FINE-GRAINED & CAS)

### Key Improvements

* **No segments**
* Uses **CAS (Compare-And-Swap)**
* Uses **synchronized blocks at bucket level**
* Tree bins (Red-Black Tree) used after collision threshold

---

## Why No ConcurrentModificationException?

* Iterators are **weakly consistent**
* Reflect some (not all) modifications
* Never throw CME

---

## ConcurrentHashMap Key Rules

* ❌ No null key
* ❌ No null values

---

### ConcurrentHashMap vs synchronizedMap

| Feature     | synchronizedMap       | ConcurrentHashMap  |
| ----------- | --------------------- | ------------------ |
| Locking     | One lock              | Fine-grained       |
| Iteration   | Needs synchronization | No synchronization |
| Performance | Medium                | 🔥 Best            |

---

## When to Use ConcurrentHashMap (INTERVIEW ANSWER)

* High concurrency
* Heavy reads & writes
* Avoid global locking

---

# 4. WeakHashMap — MEMORY-AWARE MAP

## What Is WeakHashMap?

WeakHashMap stores keys as **WeakReferences**.

### Behavior

* When key has **no strong reference**, entry is removed automatically by GC

```java
Map<Object, String> map = new WeakHashMap<>();
Object key = new Object();
map.put(key, "value");
key = null;
System.gc();
```

✅ Entry may disappear

---

## Use Cases

* Memory-sensitive caches
* Metadata associations

---

# 5. IdentityHashMap — REFERENCE COMPARISON MAP

## How IdentityHashMap Works

* Uses **==** instead of `equals()`
* Uses `System.identityHashCode()` instead of `hashCode()`

```java
Map<String, String> map = new IdentityHashMap<>();
map.put(new String("A"), "first");
map.put(new String("A"), "second");

System.out.println(map.size()); // 2
```

---

## Comparison: HashMap vs IdentityHashMap

| Feature                | HashMap    | IdentityHashMap    |
| ---------------------- | ---------- | ------------------ |
| Key comparison         | equals()   | ==                 |
| Hash used              | hashCode() | identityHashCode() |
| Duplicate logical keys | ❌          | ✅                  |

---

## When to Use IdentityHashMap

* Framework-level code
* Object graph tracking
* Proxy / serialization tools

---

# ✅ FINAL INTERVIEW SUMMARY

✅ Hashtable → legacy, synchronized, slow
✅ HashMap → fast, non-thread-safe
✅ ConcurrentHashMap → scalable, thread-safe
✅ WeakHashMap → GC-driven cleanup
✅ IdentityHashMap → reference equality

> 🎯 If you can explain **why each exists**, you're operating at **senior interview level**.

# End of Advanced Map Types Notes
